package PageObject;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Login extends BaseObjectPage {

	WebDriverWait wait;

	public Login(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	@FindBy(xpath = "//a[@title='My Account']")
	WebElement myAC;

	@FindBy(xpath = "//a[normalize-space()='Login']")
	WebElement login;

	@FindBy(xpath = "//input[@placeholder='E-Mail Address']")
	WebElement loginemail;

	@FindBy(xpath = "//input[@id='input-password']")
	WebElement loginpassword;

	@FindBy(xpath = "//input[@value='Login']")
	WebElement loginbtn;

	@FindBy(xpath = "//h2[normalize-space()='My Orders']")
	WebElement loginsucces;

	@FindBy(xpath = "//a[@class='list-group-item'][normalize-space()='Logout']")
	WebElement logout;

	@FindBy(xpath = "//a[normalize-space()='Continue']")
	WebElement continueB1;

	public void AccountTAB() {
		myAC.click();
	}

	public void loginTAB() {
		login.click();
	}

	public void credentials(String email, String Password) throws InterruptedException {
		loginemail.sendKeys(email);
		loginpassword.sendKeys(Password);
		loginbtn.click();
		Thread.sleep(5000);
		loginemail.clear();
		loginpassword.clear();
		
		

	}

	public boolean SuccessMessage() {
		return loginsucces.isDisplayed();
	}

	public void Logoutreg() {
		logout.click();
		continueB1.click();

	}

}
