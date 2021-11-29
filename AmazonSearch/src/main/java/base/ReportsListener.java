package base;

import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;

public class ReportsListener implements ITestListener
{
	//ReportEngine ext = new ReportEngine();

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestStart(result);
		ReportEngine.test = ReportEngine.extent.createTest(result.getName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestSuccess(result);
		ReportEngine.test.log(Status.PASS, "Test passed : "+result.getName());
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailure(result);
		ReportEngine.test.log(Status.FAIL, "Test failed : "+result.getName());
		try {
			ReportEngine.test.addScreenCaptureFromPath(Screenshot.screenshot(result.getName()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestSkipped(result);
		ReportEngine.test.log(Status.SKIP, "Test skipped : "+result.getName());
	}

}
