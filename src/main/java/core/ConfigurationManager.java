package core;

import enums.DriverType;
import util.PropertyReader;

public class ConfigurationManager {

	private static ConfigurationManager instance;
	private ConfigurationManager() {
		
	}
	
	public static ConfigurationManager getConfigManager() {
		if(instance==null) {
			instance = new ConfigurationManager();
		}
		return instance;
	}
	
	public DriverType getBrowser() {
		String browserName = PropertyReader.getData("browser");
		if(browserName.equalsIgnoreCase("chrome")) {
			return DriverType.CHROME;
		}else if(browserName.equalsIgnoreCase("firefox")) {
			return DriverType.FIREFOX;
		}else if(browserName.equalsIgnoreCase("edge")) {
			return DriverType.EDGE;
		}else {
			throw new IllegalAccessError("Please specify a valid browser, got "+browserName+", Expected list : "+DriverType.CHROME+", "+DriverType.FIREFOX+", "+DriverType.EDGE);
		}
	}
}
