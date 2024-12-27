package Testcases;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import PageObject.RegisterLogin;

public class RegisterTestcases extends BasetestCases {

	RegisterLogin rg;
	TestResultHandlerSS Testhandler;

	@BeforeClass
	@Parameters("browser")
	public void normalsetup(String browser) throws IOException {
		setup(browser);
		rg = new RegisterLogin(driver);
		Testhandler = new TestResultHandlerSS(driver);

	}

	@Test(priority = 1)
	public void GoReg() {
		rg.MyAccount();
	}

	@Test(priority = 2)
	public void PersnolDel() {
		rg.Enterdetails();
	}

	@Test(priority = 3)
	public void EnterPassword() {
		rg.EnterPass();
	}

	@Test(priority = 4)
	public void AgreeClick() {
		rg.AgreeCheckbox();
	}

	@Test(priority = 5)
	public void Submit() {
		rg.Subclick();
	}

	@Test(retryAnalyzer = retryfailedcases.class, priority = 6)
	public void issucces() {
		Assert.assertTrue(rg.isDisplay());
	}

	@Test(dependsOnMethods = { "issucces" })
	public void login() throws InterruptedException {
		rg.login();

	}

	@AfterMethod
	public void testhandle(ITestResult result) {
		Testhandler.handleTestResult(result);
	}

	@AfterClass
	public void close() {
		driver.quit();
	}

}
