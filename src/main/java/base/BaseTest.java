package base;

import org.openqa.selenium.WebDriver;


import core.DriverManager;
import core.OutputLog;
import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;
import util.ExcelUtils;
import util.ScreenshotUtility;

public class BaseTest {
	
	private WebDriver driver;// = DriverManager.getDriverManager().getDriver();
	
	@Before //Execute before ever scenario
	public void config() {
        
	}
	
	@Before("@Sanity") //Execute before every @Sanity tagged scenario
	public void beforeSanity() {
		//driver = DriverManager.getDriverManager().getDriver();
	}
	
	@BeforeStep() //Execute before every step
	public void beforeStep() {
		
	}
	
	@AfterStep() //Execute after every step
	public void afterStep(Scenario sc) {
		if(sc.isFailed()) {
			//OutputLog.info("Scenario : "+sc.getName()+" is FAILED, Capturing Screenshot...");
			//ScreenshotUtility.captureScreenshot(driver, sc.getName());
			sc.attach(ScreenshotUtility.getScreenshotAsByte(driver), "image/png", sc.getName());			
		}
	}
	
	@After("@Sanity") //Execute after every @Sanity tagged scenario
	public void afterSanity() {
	}
	
	@After //Execute after every scenario
	public void AfterScenario() {
		OutputLog.info("Tearing down the driver...");
		DriverManager.getDriverManager().quitDriver();
	}
	
	@AfterAll
	public static void afterAll() {
//		OutputLog.info("Tearing down the driver...");
//		DriverManager.getDriverManager().quitDriver();
	}
}
