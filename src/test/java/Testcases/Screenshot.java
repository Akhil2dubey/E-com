package Testcases;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Screenshot extends BasetestCases implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        // Check if driver is initialized
        if (driver != null) {
            // Capture screenshot
            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            try {
                // Create screenshots directory if it doesn't exist
                File screenshotDir = new File("screenshots");
                if (!screenshotDir.exists()) {
                    screenshotDir.mkdirs();
                }

                // Construct the screenshot file path
                String screenshotName = result.getName() + ".png";
                File destination = new File(screenshotDir, screenshotName);

                // Copy the screenshot to the destination
                FileUtils.copyFile(screenshot, destination);
                System.out.println("Screenshot saved at: " + destination.getAbsolutePath());
            } catch (IOException e) {
                System.err.println("Failed to save screenshot: " + e.getMessage());
                e.printStackTrace();
            }
        } else {
            System.err.println("WebDriver is null. Cannot capture screenshot.");
        }
    }
}
