//package Testcases;
//
//import java.io.File;
//import java.io.IOException;
//import java.util.logging.FileHandler;
//
//import org.openqa.selenium.OutputType;
//import org.openqa.selenium.TakesScreenshot;
//import org.testng.ITestListener;
//import org.testng.ITestResult;
//
//public class Screenshot implements ITestListener {
//	 @Override
//	    public void onTestFailure(ITestResult result) {
//	        // Capture screenshot
//	        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//	        try {
//	            String screenshotName = result.getName() + ".png";
//	            File destination = new File("screenshots/" + screenshotName);
//	            FileHandler.copy(screenshot, destination);
//	            System.out.println("Screenshot saved at: " + destination.getAbsolutePath());
//	        } catch (IOException e) {
//	            e.printStackTrace();
//	        }
//	    }
//}
