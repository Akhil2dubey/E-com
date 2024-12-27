package Testcases;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;

public class TestResultHandlerSS {

    private WebDriver driver;

    // Constructor to initialize WebDriver
    public TestResultHandlerSS(WebDriver driver) {
        this.driver = driver;
    }

    // Method to handle the test result
    public void handleTestResult(ITestResult result) {
        if (result.getStatus() == ITestResult.SUCCESS) {
            System.out.println(result.getMethod().getMethodName() + " testcase is passed ");
        } else if (result.getStatus() == ITestResult.FAILURE) {
            System.out.println(result.getMethod().getMethodName() + " testcase is failed ");

            // Capture screenshot for failed test case
            try {
                File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                File screenshotDir = new File("screenshots");

                // Save the screenshot with the test method name
                File destination = new File(screenshotDir, result.getMethod().getMethodName() + ".png");
                FileUtils.copyFile(screenshot, destination);
                System.out.println("Screenshot saved at: " + destination.getAbsolutePath());
            } catch (IOException e) {
                System.err.println("Failed to save screenshot: " + e.getMessage());
                e.printStackTrace();
            }
        } else if (result.getStatus() == ITestResult.SKIP) {
            System.out.println(result.getMethod().getMethodName() + " testcase is skipped ");
        }
    }
}
