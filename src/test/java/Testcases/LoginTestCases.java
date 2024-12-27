package Testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;
import com.github.dockerjava.api.model.Driver;

import PageObject.Login;

public class LoginTestCases extends BasetestCases {

	Login l;
	TestResultHandlerSS testhandler;

	@BeforeClass
	@Parameters("browser")
	public void setupTest(String browser) throws IOException {
		setup(browser); // Initializes WebDriver and other configurations
		l = new Login(driver);
		testhandler = new TestResultHandlerSS(driver);
	}

	@Test(priority = 1)
	public void openAccount() {
		l.AccountTAB(); // Navigate to the account tab
	}

	@Test(priority = 2)
	public void clickLoginTab() {
		l.loginTAB(); // Click on the login tab
	}

	@DataProvider(name = "testdata")
	public Object[][] getLoginData() {
		return new Object[][] { { "zzzz@gmail.com", "ram1231324" }, // InValid credentials
				{ "asdfghj@gmail.com", "ram@123" } // Valid credentials
		};
	}

	@Test(dataProvider = "testdata", priority = 3)
	public void enterCredentialsAndVerify(String email1, String password1) throws InterruptedException {
		// Enter credentials
		String email = email1;
		String password = password1;
		l.credentials(email, password);
		// Assert.assertTrue(l.SuccessMessage());
		System.out.println("valis credentials " + email1 + password1);

	}

	@Test(priority = 4)
	public void logoutAccount() {
		l.Logoutreg(); // Perform logout action
	}

	@AfterMethod
	public void TestRsult(ITestResult result) {
		testhandler.handleTestResult(result);
	}

	@AfterClass
	public void close() {
		driver.quit();
	}
}
