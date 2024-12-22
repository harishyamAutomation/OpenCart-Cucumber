package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

import constants.Constants;

public class PropertyReader {

	private static Properties getPropertyFile() {
		FileInputStream fis;
		Properties properties = null;
		try {
			fis = new FileInputStream(new File(Constants.CONFIG_PROPERTIES));
			properties = new Properties();
			properties.load(fis);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return properties;
	}
	
	public static String getData(String key) {
		return (String) PropertyReader.getPropertyFile().get(key);
	}
	
	//Method to set the property to file
		public static void setProperty(String key, String value) {
			
			//System.out.println("Current Working Directory [PropertyReader] : "+new File(".").getAbsolutePath());
			
			try {
				InputStream propertyFile = new FileInputStream(Constants.LOG4J2_PROPERTIES);
				Properties properties = new Properties();
				properties.load(propertyFile);
				properties.setProperty(key, value);
				OutputStream saveChanges = new FileOutputStream(Constants.LOG4J2_PROPERTIES);
				properties.store(saveChanges, null);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println(e);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println(e);
			}
		}
	
}
