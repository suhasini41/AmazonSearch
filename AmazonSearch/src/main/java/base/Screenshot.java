package base;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import utility.TiemStamp;

public class Screenshot extends Base
{
	
	public static String screenshot(String methodName)
	{
		String timeStamp = TiemStamp.timestamp();
		String screenshotPath = "D:\\AmazonSearch\\AmazonSearch\\Screenshots\\"+methodName+"_"+timeStamp+".png";
		TakesScreenshot screenshot = (TakesScreenshot)driver;
		File src = screenshot.getScreenshotAs(OutputType.FILE);
		File target = new File(screenshotPath);
		try {
			FileUtils.copyFile(src, target);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return screenshotPath;
	}

}
