package PageObject;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegisterLogin extends BaseObjectPage {

	WebDriverWait wait;

	public RegisterLogin(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	@FindBy(xpath = "//a[@title='My Account']")
	WebElement myAC;

	@FindBy(xpath = "//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Register']")
	WebElement RegisterOption;

	@FindBy(xpath = "//input[@name='firstname']")
	WebElement Fname;

	@FindBy(xpath = "//input[@name='lastname']")
	WebElement Lname;

	@FindBy(xpath = "//input[@ name='email']")
	WebElement Email;

	@FindBy(xpath = "//input[@id='input-telephone']")
	WebElement Telephone;

	@FindBy(xpath = "//input[@id='input-password']")
	WebElement pass;

	@FindBy(xpath = "//input[@id='input-confirm']")
	WebElement ConfirmPass;

	@FindBy(xpath = "//input[@name='agree']")
	WebElement AgreeCheck;

	@FindBy(xpath = "//input[@value='Continue']")
	WebElement ContinueButton;

	@FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement succesMessage;

	@FindBy(xpath = "//a[@class='list-group-item'][normalize-space()='Logout']")
	WebElement logout;

	@FindBy(xpath = "//a[normalize-space()='Continue']")
	WebElement continueB1;

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

	public void MyAccount() {
		wait.until(ExpectedConditions.visibilityOf(myAC));
		myAC.click();
		RegisterOption.click();
	}

	public void Enterdetails() {
		Fname.sendKeys("akhil");
		Lname.sendKeys("Dubey");
		Email.sendKeys("asdfghj@gmail.com");
		Telephone.sendKeys("9755128182");

	}

	public void EnterPass() {
		pass.sendKeys("ram@123");
		ConfirmPass.sendKeys("ram@123");
	}

	public void AgreeCheckbox() {
		AgreeCheck.click();

	}

	public void Subclick() {
		ContinueButton.click();
	}

	public boolean isDisplay() {
		return succesMessage.isDisplayed();

	}

	public void login() throws InterruptedException {
		Thread.sleep(5000);
		logout.click();
		continueB1.click();
		myAC.click();
		login.click();
		loginemail.sendKeys("asdfghj@gmail.com");
		loginpassword.sendKeys("ram@123");
		loginbtn.click();

	}
}
