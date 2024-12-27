package Testcases;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import PageObject.GiveReview;

public class ReviewTestcases extends BasetestCases {
	GiveReview gr;
	TestResultHandlerSS testhandler;

	@BeforeClass
	@Parameters("browser")
	public void normasetup(String browser) throws IOException {
		setup(browser);
		gr = new GiveReview(driver);
		testhandler = new TestResultHandlerSS(driver);
	}

	@Test(priority = 1)
	public void MyAccountTab() {
		gr.MyACCOUNT();
	}

	@Test(priority = 2)
	public void CredentialsDetails() {
		gr.EnterCredentials();
	}

	@Test(priority = 3)
	public void loginClick() {
		gr.clickLogin();
	}

	@Test(priority = 4)
	public void Mp3Player() {
		gr.mp3TAB();

	}

	@Test(priority = 5)
	public void sortpro() {
		gr.SortProduct();
	}

	@Test(priority = 6)
	public void OpenProd() {
		gr.openPro();
	}

	@Test(priority = 7)
	public void ReviewTABSelect() {
		gr.reviewTAB();
	}

	@Test(priority = 8)
	public void EnteryourREVIEW() {
		gr.ENTreview();
	}

	@Test(priority = 9)
	public void velidatepageloaded() {
		String tile = driver.getTitle();
		assertEquals(tile, "iPod ");
	}

	@Test(priority = 10)
	public void SubmitReview() {
		gr.sbtReview();
	}

	@Test(retryAnalyzer = retryfailedcases.class, priority = 11)
	public void TestcaseResult() {
		Assert.assertTrue(gr.SuccessMessage());
	}

	@Test(priority = 12)
	public void clodebrowser() {
		driver.quit();
	}

	@AfterMethod
	public void testhandler(ITestResult result) {
		testhandler.handleTestResult(result);
	}

	@AfterClass
	public void close() {
		driver.quit();
	}
}
