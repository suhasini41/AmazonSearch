package test;

import static org.testng.Assert.assertTrue;

import java.util.HashMap;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.Base;
import pages.HomePage;
import pages.SearchResultPage;
import test_data.TestDataReader;

public class SearchResultPageTest extends Base  implements TabInterface
{
	SearchResultPage srp;
	HomePage hp;
	
	
	@BeforeClass
	public void initialize()
	{
		srp = PageFactory.initElements(driver, SearchResultPage.class);
		hp = PageFactory.initElements(driver, HomePage.class);
	}
	
	@Test
	public void testTitle()
	{
		Assert.assertEquals(srp.getTitle(), "Amazon.com : toys");
	}
	
	@Test
	public void testHeading()
	{
		Assert.assertTrue(srp.getHeading().contains("toys"));
	}

	@Test
	public void testSearchResultNotNull()
	{
		Assert.assertNotNull(srp.products());
	}
	
	@DataProvider(name="readData")
	public Object[][] readData()
	{
		Object[][] data = TestDataReader.read("D:\\AmazonSearch\\AmazonSearch\\src\\main\\java\\test_data\\AmazonProducts.xlsx", "AmazonProducts");
		return data;
	}
	
	@Test(dataProvider = "readData",priority=1)
	public void searchMultipleProducts(HashMap product)
	{
		hp.getSearch().clear();
		System.out.println(product.get("Products"));
		String str = (String) product.get("Products");
		hp.getSearch().sendKeys(str);
	}
}
