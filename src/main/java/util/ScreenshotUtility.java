package util;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtility {

	static TakesScreenshot takeScreenshot;
	public static void captureScreenshot(WebDriver driver, String screenshotName) {
		if(takeScreenshot==null) {
			takeScreenshot = (TakesScreenshot) driver;
		}
		
		File source = takeScreenshot.getScreenshotAs(OutputType.FILE);
		System.setProperty("org.uncommons.reportng.escape-output", "true");
		File destination = new File(PropertyReader.getData("screenshotPath")+screenshotName+".png");
		try {
			FileUtils.copyFile(source, destination);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("Screenshot directory path is incorrect...");
		}
	}
	
	public static byte[] getScreenshotAsByte(WebDriver driver) {
		if(takeScreenshot==null) {
			takeScreenshot = (TakesScreenshot) driver;
		}
		return takeScreenshot.getScreenshotAs(OutputType.BYTES);
	}
}
