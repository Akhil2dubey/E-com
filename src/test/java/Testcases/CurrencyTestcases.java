package Testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import PageObject.Currency;

public class CurrencyTestcases extends BasetestCases {

	Currency c;
	TestResultHandlerSS testresult;

	@Parameters("browser")
	@BeforeClass
	public void normalsetup(String browser) throws IOException {

		setup(browser);
		c = new Currency(driver);
		testresult = new TestResultHandlerSS(driver);

	}

	@Test(priority = 1)
	public void loginpage() {
		c.MyACCOUNT();
	}

	@Test(priority = 2)
	public void Enterdetails() {
		c.EnterCredentials();
	}

	@Test(priority = 3)
	public void loginbutton() {
		c.clickLogin();
	}

	@Test(priority = 4)
	public void ClickOnCurrency() {
		c.currencyicon();
	}

	@Test(dependsOnMethods = "ClickOnCurrency", priority = 5)
	public void selectcurrency() {
		c.euroselect();
	}

	@Test(priority = 6)
	public void moveToHomepage() {
		c.clickhomepage();
	}

	@Test(retryAnalyzer = retryfailedcases.class, priority = 7)
	public void TestVerification() {
		Assert.assertTrue(c.isdisplay());
	}

	@AfterMethod
	public void testalltest(ITestResult result) {
		testresult.handleTestResult(result);
	}

}
