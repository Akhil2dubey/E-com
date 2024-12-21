package PageObject;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddToCart extends BaseObjectPage {

	WebDriverWait wait;

	public AddToCart(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
 	}

	@FindBy(xpath = "//a[@class='dropdown-toggle'][normalize-space()='Components']")
	WebElement componentTAB;

	@FindBy(xpath = "//a[normalize-space()='Monitors (2)']")
	WebElement monitorTAB;

	@FindBy(xpath = "//body[1]/div[2]/div[1]/div[1]/div[3]/div[1]/div[1]/div[2]/div[2]/button[1]")
	WebElement additem;

	@FindBy(xpath = "//input[@value='10']")
	WebElement checkbox;

	@FindBy(xpath = "//input[@id='input-option208']")
	WebElement EnterText;

	@FindBy(xpath = "//select[@id='input-option217']")
	WebElement dropdown;

	@FindBy(xpath = "//textarea[@id='input-option209']")
	WebElement textarea;

	@FindBy(xpath = "//button[@id='button-upload222']")
	WebElement up;

	@FindBy(xpath = "//div[@class='input-group date']//button[@type='button']")
	WebElement calender;

	@FindBy(xpath = "//body[1]/div[3]/div[1]/div[1]/table[1]/tbody[1]/tr[3]/td[5]")
	WebElement date;

	@FindBy(xpath = "//input[@id='input-option221']")
	WebElement time;

	@FindBy(xpath = "//input[@id='input-option220']")
	WebElement dateTime;

	@FindBy(xpath = "//input[@id='input-quantity']")
	WebElement qty;

	@FindBy(xpath = "//button[@id='button-cart']")
	WebElement addcartbtn;

	public void componentsTAB() {

		wait.until(ExpectedConditions.visibilityOf(componentTAB));
		Actions a = new Actions(driver);
		a.moveToElement(componentTAB).build().perform();
		monitorTAB.click();

	}

	public void OpenProduct() {
		additem.click();

	}

	public void checkboxCHECK() {
		checkbox.click();
	}

	public void TextFill() {
		EnterText.click();
		EnterText.sendKeys("I can Buy This");

	}

	public void SelectColor() {
		Select s = new Select(dropdown);

		s.selectByVisibleText("Blue (+$3.60)");
	}

	public void Textarea() {
		textarea.click();
		textarea.sendKeys("i should buy this");
	}

	public void FileUpLoad(String filePath) throws AWTException {
		up.click();
		StringSelection filePathSelection = new StringSelection(filePath);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filePathSelection, null);

		Robot robot = new Robot();
		robot.delay(1000);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);

		try {
			wait.until(ExpectedConditions.alertIsPresent()); // Wait for the alert
			Alert alert = driver.switchTo().alert(); // Switch to the alert
			alert.accept(); // Accept the alert (click OK)
		} catch (Exception e) {
			System.out.println("No alert appeared: " + e.getMessage());
		}
	}

	public void Clndr() {
		calender.click();
		date.click();
	}

	public void TimeInput() {
		time.click();
		time.sendKeys("22.00");
	}

	public void DateTimeInput() {
		dateTime.sendKeys("2012-02-20 22:25");
	}

	public void enterQTY() {
		qty.sendKeys("2");
	}

	public void AddClick() {
		addcartbtn.click();
	}
}
