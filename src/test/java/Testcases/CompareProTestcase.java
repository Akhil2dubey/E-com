package Testcases;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import PageObject.CompareProduct;

public class CompareProTestcase extends BasetestCases {

	CompareProduct c;

	@BeforeClass
	public void normalsetup() throws IOException {
		setup();
		c = new CompareProduct(driver);

	}

	@Test(priority = 1)
	public void loginAcount() {
		c.MyACCOUNT();
		c.EnterCredentials();
		c.clickLogin();
	}

	@Test(priority = 2)
	public void PhoneTAB() {
		c.PhoneANDpdaTAB();
	}

	@Test(priority = 3)
	public void AddPro1() {
		c.AddProduct1();
	}

	@Test(priority = 4)
	public void AddPro2() {
		c.AddProduct2();
	}

	@Test(priority = 5)
	public void coparebuttonclick() {
		c.clickoncompare();
	}

	@Test(retryAnalyzer = retryfailedcases.class, priority = 6)
	public void issuccess() {
		Assert.assertTrue(c.isDisplay());
	}

	@AfterClass
	@Test(priority = 7)
	public void closebrowser() {
		driver.quit();
	}

}
