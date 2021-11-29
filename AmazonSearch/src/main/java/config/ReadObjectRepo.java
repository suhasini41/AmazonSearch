package config;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadObjectRepo 
{
	FileInputStream in = null;
	Properties prop = new Properties();
	
	public ReadObjectRepo()
	{
		try {
			in = new FileInputStream(new File("D:\\AmazonSearch\\AmazonSearch\\src\\main\\java\\config\\ObjectRepo.properties"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			prop.load(in);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public String getTabXpath()
	{
		return prop.getProperty("tab_xpath");
	}

}
