package Testcases;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class rtry implements IRetryAnalyzer{

	
	private int count=0;
	private final int maxcount=5;
	
	@Override
	public boolean retry(ITestResult result) {
		// TODO Auto-generated method stub
		if(count<maxcount)
		{
		count++;
		return true;
		}
		return false;
	}

}

