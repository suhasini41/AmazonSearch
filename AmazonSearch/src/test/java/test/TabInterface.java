package test;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.Base;
import config.ReadObjectRepo;

public interface TabInterface
{
	ReadObjectRepo readRepo = new  ReadObjectRepo();
	
	@Test
	default
	void testPresenceOfTabElements()
	{
		boolean flag = Base.driver.findElements(By.xpath(readRepo.getTabXpath())).size()==3;
		System.out.println(Base.driver.findElements(By.xpath(readRepo.getTabXpath())).size());
		Assert.assertTrue(flag);
	}

}
