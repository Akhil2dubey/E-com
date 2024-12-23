package PageObject;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CompareProduct extends BaseObjectPage {

	WebDriverWait wait;

	public CompareProduct(WebDriver driver) {
		super(driver);
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@title='My Account']")
	WebElement myac;

	@FindBy(xpath = "//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Login']")
	WebElement login;

	@FindBy(xpath = "//input[@id='input-email']")
	WebElement email;

	@FindBy(xpath = "//input[@id='input-password']")
	WebElement pass;

	@FindBy(xpath = "//input[@value='Login']")
	WebElement loginbtn;

	@FindBy(xpath = "//ul[@class='nav navbar-nav']//a[contains(text(),'Phones & PDAs')]")
	WebElement phoneandPda;

	@FindBy(xpath = "//body[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[2]/button[3]")
	WebElement product1;

	@FindBy(xpath = "//body[1]/div[2]/div[1]/div[1]/div[2]/div[3]/div[1]/div[2]/div[2]/button[3]")
	WebElement product2;

	@FindBy(xpath = "//a[@id='compare-total']")
	WebElement comparebutton;

	@FindBy(xpath = "///h1[normalize-space()='Product Comparison']")
	WebElement success;

	public void MyACCOUNT() {
		wait.until(ExpectedConditions.visibilityOf(myac));
		myac.click();
		login.click();

	}

	public void EnterCredentials() {
		email.sendKeys("asdfghj@gmail.com");
		pass.sendKeys("ram@123");
	}

	public void clickLogin() {
		loginbtn.click();
	}

	public void PhoneANDpdaTAB() {
		phoneandPda.click();
	}

	public void AddProduct1() {
		
		wait.until(ExpectedConditions.visibilityOf(product1));
		Actions a=new Actions(driver);
		a.moveToElement(product1).build().perform();
		product1.click();
	}

	public void AddProduct2() {
		wait.until(ExpectedConditions.visibilityOf(product2));
		product2.click();
	}
	public void clickoncompare() {
		
		comparebutton.click();
	}
	public boolean isDisplay() {
		return success.isDisplayed();
		
	}
}
