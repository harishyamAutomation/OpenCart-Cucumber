package core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import enums.DriverType;
import util.PropertyReader;

public class DriverManager {

	private static WebDriver driver;
	private static DriverType driverType;
	private static DriverManager instance;
	
	private DriverManager() {
		driverType = ConfigurationManager.getConfigManager().getBrowser();
	}
	
	public static DriverManager getDriverManager() {
		if(instance==null) {
			instance =  new DriverManager();
		}
		return instance;
	}
	
	public WebDriver getDriver() {
			driver = createDriver();
		return driver;
	}
	
	private WebDriver createDriver() {
		switch (driverType) {
		case CHROME:
			System.setProperty("webdriver.chrome.driver", PropertyReader.getData("chromeDriverPath"));
			ChromeOptions chromeOptions = new ChromeOptions();
			chromeOptions.setAcceptInsecureCerts(true);
			chromeOptions.addArguments("use-fake-ui-for-media-stream");
			driver = new ChromeDriver(chromeOptions);
			break;
		case FIREFOX:
			System.setProperty("webdriver.firefox.driver", PropertyReader.getData("fireFoxDriverPath"));
			FirefoxOptions ffOptions = new FirefoxOptions();
			ffOptions.setAcceptInsecureCerts(true);
			ffOptions.addArguments("use-fake-ui-for-media-stream");
			driver = new FirefoxDriver(ffOptions);
			break;
		case EDGE:
			System.setProperty("webdriver.edge.driver", PropertyReader.getData("edgeDriverPath"));
			EdgeOptions edgeOptions = new EdgeOptions();
			edgeOptions.setAcceptInsecureCerts(true);
			edgeOptions.addArguments("use-fake-ui-for-media-stream");
			driver = new EdgeDriver(edgeOptions);
			break;

		default:
			System.setProperty("webdriver.chrome.driver", PropertyReader.getData("chromeDriverPath"));
			ChromeOptions options = new ChromeOptions();
			options.setAcceptInsecureCerts(true);
			options.addArguments("use-fake-ui-for-media-stream");
			driver = new ChromeDriver(options);
			break;
		}
		return driver;
	}
	
	public void quitDriver() {
		if(driver!=null) {
			driver.quit();
			driver=null;
		}
	}
}
