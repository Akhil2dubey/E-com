package Testcases;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.beust.jcommander.Parameter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasetestCases {

	WebDriver driver;
	Properties p;

	@Parameters({ "browser" })
	public void setup(String browser) throws IOException {
		FileReader f = new FileReader(
				"C:\\Users\\akhil dwivedi\\eclipse-workspace\\Komal project\\E-comarce.Newgen.com\\src\\test\\resources\\datapro");
		p = new Properties();
		p.load(f);
		if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			ChromeOptions coption = new ChromeOptions();
			driver = new ChromeDriver(coption);

		} else if (browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			FirefoxOptions foption = new FirefoxOptions();
			driver = new FirefoxDriver(foption);

		} else {
			IllegalArgumentExceptoin("Invalid browser name " + browser);
		}

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		driver.get(p.getProperty("url"));

	}

	private void IllegalArgumentExceptoin(String string) {
		// TODO Auto-generated method stub

	}

}
