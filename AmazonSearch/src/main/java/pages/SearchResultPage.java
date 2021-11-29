package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchResultPage
{
	WebDriver driver;
	
	@FindBy(xpath="//div[contains(@class,'sg-col-4-of-12 s-result-item')]")
	List<WebElement> products;
	
	@FindBy(xpath="//span[@class='a-color-state a-text-bold']")
	WebElement heading;
	
	public SearchResultPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public List<WebElement> products()
	{
		return products;
	}
	
	public String getTitle()
	{
		return driver.getTitle();
	}
	public String getHeading()
	{
		return heading.getText();
	}
}
