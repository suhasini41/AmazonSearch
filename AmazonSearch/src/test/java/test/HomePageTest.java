package test;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.Base;
import pages.HomePage;

public class HomePageTest extends Base implements TabInterface
{
	HomePage hp;
	
	@BeforeClass
	public void  initialize()
	{
		hp = PageFactory.initElements(driver, HomePage.class);
	}
	
	@Test
	public void testTitle()
	{
		Assert.assertEquals(hp.getTitle(),"Amazon.com. Spend less. Smile more.");
	}
	
	@Test(priority=1)
	public void testSearchBox()
	{
		hp.enterTextInSearchBox("toys");
		hp.clickSearchIcon();
	}
}
