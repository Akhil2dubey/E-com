package PageObject;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Currency extends BaseObjectPage {

	WebDriverWait wait;

	public Currency(WebDriver driver) {
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

	@FindBy(xpath = "//form[contains(@action, 'ncart/index.php?route=common/currency/currency')]")
	WebElement currency;

	@FindBy(xpath = "//button[@name='EUR']")
	WebElement Euro;
	
	@FindBy(xpath="//img[@title='naveenopencart']")
	WebElement homepage;

	@FindBy(xpath = "//p[contains(text(),'96.66€')]")
	WebElement success;

	public void MyACCOUNT() {
		wait.until(ExpectedConditions.visibilityOf(myAC));
		myAC.click();
		login.click();

	}

	public void EnterCredentials() {
		loginemail.sendKeys("asdfghj@gmail.com");
		loginpassword.sendKeys("ram@123");
	}

	public void clickLogin() {
		loginbtn.click();
	}
	public void currencyicon() {
		wait.until(ExpectedConditions.visibilityOf(currency));
		currency.click();
	}
	public void euroselect() {
		Euro.click();
	}
	public void clickhomepage() {
		homepage.click();
	}
	public boolean isdisplay() {
		return success.isDisplayed();
		
	}
	

}
