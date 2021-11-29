package config;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig 
{
	FileInputStream in = null;
	public Properties prop = null;

	public ReadConfig()
	{
		try
		{
			in = new FileInputStream(new File("D:\\AmazonSearch\\AmazonSearch\\src\\main\\java\\config\\config.properties"));
			prop = new Properties();
			prop.load(in);
		}
		catch(IOException e)
		{
			System.out.println(e);
		}
	}
	
	public String getURL()
	{
		return prop.getProperty("url");
	}

}
