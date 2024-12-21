package Testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.github.dockerjava.api.model.Driver;

import PageObject.Login;

public class LoginTestCases extends BasetestCases {

	Login l;

	@BeforeClass
	public void setupTest() throws IOException {
		setup(); // Initializes WebDriver and other configurations
		l = new Login(driver);
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
		//Assert.assertTrue(l.SuccessMessage());
		System.out.println("valis credentials "+ email1 + password1);

	}

	@Test(priority = 4)
	public void logoutAccount() {
		l.Logoutreg(); // Perform logout action
	}

	@Test(priority = 5)
	public void closeBrowser() {
		driver.close(); // Close the browser
	}
}
