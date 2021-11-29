package base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import config.ReadConfig;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Base
{
	public static WebDriver driver = null;
	ReadConfig readconfig = new ReadConfig();
	
	
	@BeforeSuite
	public void setReports()
	{
		System.out.println("before suite");
		ReportEngine.SetUpReport();
	}
	@Parameters("browser")
	@BeforeTest
	public void init(String browser)
	{
		if(browser.equals("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if(browser.equals("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		else
			System.out.println("browser not compatible");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(readconfig.getURL());
	}
	
	
	
	@AfterTest
	public void tearDown()
	{
		driver.quit();
	}
	
	@AfterSuite
	public void writeToReport()
	{
		System.out.println("after suite");
		ReportEngine.generateReports();
	}

}
