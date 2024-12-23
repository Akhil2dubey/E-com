package Testcases;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasetestCases {

	WebDriver driver;
	Properties p;

	
	public void setup() throws IOException {
		FileReader f = new FileReader(
				"C:\\Users\\akhil dwivedi\\eclipse-workspace\\Komal project\\E-comarce.Newgen.com\\src\\test\\resources\\datapro");
		p = new Properties();
		p.load(f);

		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		driver.get(p.getProperty("url"));

	}
}
