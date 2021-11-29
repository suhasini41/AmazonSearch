package base;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryClass implements IRetryAnalyzer
{
	int count = 0,max = 3;
	@Override
	public boolean retry(ITestResult result)
	{
		if(count<max)
		{
			count++;
			return true;
		}
		return false;
	}

}
