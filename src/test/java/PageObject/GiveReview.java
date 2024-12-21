package PageObject;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GiveReview extends BaseObjectPage {

	WebDriverWait wait;

	public GiveReview(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));

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

	@FindBy(xpath = "//a[normalize-space()='MP3 Players']")
	WebElement mp3player;

	@FindBy(xpath = "//a[normalize-space()='Show All MP3 Players']")
	WebElement allmp3player;

	@FindBy(xpath = "//select[@id='input-sort']")
	WebElement sort;

	@FindBy(xpath = "//img[@title='iPod Classic']")
	WebElement product;

	@FindBy(xpath = "//a[normalize-space()='Reviews (0)']")
	WebElement revTAB;

	@FindBy(xpath = "//textarea[@id='input-review']")
	WebElement reviewBOX;

	@FindBy(xpath = "//input[@value='5']")
	WebElement ratingradio;

	@FindBy(xpath = "//button[@id='button-review']")
	WebElement reviewSubmit;

	@FindBy(xpath = "//div[normalize-space()='Thank you for your review. It has been submitted to the webmaster for approval.']")
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

	public void mp3TAB() {
		wait.until(ExpectedConditions.visibilityOf(mp3player));
		Actions ab = new Actions(driver);
		ab.moveToElement(mp3player).build().perform();
		allmp3player.click();
	}

	public void SortProduct() {
		Select s = new Select(sort);
		s.selectByVisibleText("Name (A - Z)");
	}
	
	public void	openPro() {
		
		wait.until(ExpectedConditions.visibilityOf(product));
		product.click();
	}

	public void reviewTAB() {
		wait.until(ExpectedConditions.visibilityOf(revTAB));
		revTAB.click();
	}

	public void ENTreview() {
		reviewBOX.sendKeys("t");
		ratingradio.click();
	}

	public void sbtReview() {
		reviewSubmit.click();
	}

	public boolean SuccessMessage() {
		return success.isDisplayed();
	}

}
