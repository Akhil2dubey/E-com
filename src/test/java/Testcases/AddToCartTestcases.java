package Testcases;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.annotations.Parameters;
import PageObject.AddToCart;

public class AddToCartTestcases extends BasetestCases {

	AddToCart atc1;

	private TestResultHandlerSS resultHandler;

	@BeforeClass
	@Parameters("browser")
	public void normalSetup(String browser) throws IOException {
		setup(browser); // Pass the browser name dynamically
		atc1 = new AddToCart(driver);

		// Initialize the TestResultHandler with WebDriver
		resultHandler = new TestResultHandlerSS(driver);
	}

	@Test(priority = 1)
	public void ComponetsTABOpen() {
		atc1.componentsTAB();
	}

	@Test(priority = 2)
	public void Openitem() {
		atc1.OpenProduct();
	}

	@Test(priority = 3)
	public void checkthebox() {
		atc1.checkboxCHECK();
	}

	@Test(priority = 4)
	public void EntrText() {
		atc1.TextFill();
	}

	@Test(priority = 5)
	public void selectthecolor() {
		atc1.SelectColor();
	}

	@Test(priority = 6)
	public void textAea() {
		atc1.Textarea();
	}

	@Test(priority = 7)
	public void UploadTheFile() throws AWTException {
		String filePath = "C:\\Users\\akhil dwivedi\\Desktop\\2 (1).jpg";
		atc1.FileUpLoad(filePath);
	}

	@Test(priority = 8)
	public void calenderupdate() {
		atc1.Clndr();
	}

	@Test(priority = 9)
	public void timeselect() {
		atc1.TimeInput();
	}

	@Test(priority = 10)
	public void filldatetime() {
		atc1.DateTimeInput();
	}

	@Test(priority = 11)
	public void selectQTY() {
		atc1.enterQTY();
	}

	@Test(priority = 12)
	public void AddToProduct() {
		atc1.AddClick();
	}

	@AfterMethod
	public void handleResult(ITestResult result) {
		resultHandler.handleTestResult(result); // Delegate the handling to TestResultHandler
	}

	@AfterClass
	public void close() {
		if (driver != null) {
			driver.quit();
			driver = null;
		}
//	@DataProvider(name="imageData")
//	public Object[] data() {
//		return new Object[] {"C:\\Users\\akhil dwivedi\\Desktop"};
//		
//	}
	}

}