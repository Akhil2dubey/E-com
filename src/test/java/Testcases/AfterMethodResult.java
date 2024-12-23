package Testcases;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;

public class AfterMethodResult {

	@AfterMethod
	public void afterMethodresult(ITestResult result) {
		if(result.getStatus()==ITestResult.SUCCESS) {
			System.out.println("The test is succes "+ result.getMethod().getMethodName());
		}
		else if (result.getStatus()==ITestResult.FAILURE) {
			System.out.println("The test is failed "+ result.getMethod().getMethodName());
		}
		else if (result.getStatus()==ITestResult.SKIP){
			System.out.println("The test is skiped "+ result.getMethod().getMethodName());
		}
	}
}
