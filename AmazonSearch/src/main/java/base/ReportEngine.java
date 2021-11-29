package base;

import java.io.File;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ReportEngine
{
	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest test;
	public static void SetUpReport()
	{
		extent = new ExtentReports();
		htmlReporter = new ExtentHtmlReporter(new File("D:\\AmazonSearch\\AmazonSearch\\Reports\\MyReports.html"));
		extent.attachReporter(htmlReporter);
		htmlReporter.config().setDocumentTitle("Amazon Test");
		htmlReporter.config().setReportName("Amazon_Extent_Report");
		htmlReporter.config().setTheme(Theme.DARK);
	}
	
	public static void generateReports()
	{
		extent.flush();
	}

}
