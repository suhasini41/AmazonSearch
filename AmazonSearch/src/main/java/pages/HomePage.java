package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import config.ReadObjectRepo;

public class HomePage
{
	WebDriver driver=null;
	
	@FindBy(id="twotabsearchtextbox")
	WebElement search;
	
	@FindBy(id="nav-search-submit-button")
	WebElement searchIcon;
	
	@FindBy(id="nav-logo-sprites")
	WebElement logo;
	
	public HomePage(WebDriver driver)
	{
		this.driver = driver;
		
	}
	
	public WebElement getSearch()
	{
		return search;
	}
	
	public String getTitle()
	{
		return driver.getTitle();
	}
	public WebElement logoDisplay()
	{
		return logo;
	}
	public void enterTextInSearchBox(String productName)
	{
		search.sendKeys(productName);
	}
	public void clickSearchIcon()
	{
		searchIcon.click();
	}
	
}
