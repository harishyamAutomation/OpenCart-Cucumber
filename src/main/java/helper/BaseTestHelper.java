package helper;

import java.io.File;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class BaseTestHelper {
	
	//Create folder if not exists
	public static void createFoler(String path) {
		File file = new File(path);
		if(!file.exists()) {
			file.mkdir();
		}
	}

	//get the current date
	public static String currentDate() {
		LocalDate currentDate = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEE dd MMM YYYY");
		String formattedDate = currentDate.format(formatter).replace(" ", "_");
		return formattedDate;
	}

	//get current time-stamp
	public static String timeStamp() {
		LocalDateTime currentDateTime = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEE dd MMM YYYY HH:mm:ss");
		String formattedTimeStamp = currentDateTime.format(formatter).replace(":", "_").replace(" ", "_");
		return formattedTimeStamp;
	}

	//get the current date
	public static String currentDateStamp() {
		LocalDateTime currentDateTime = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HHmmssddMMYYYY");
		String formattedTimeStamp = currentDateTime.format(formatter).replace(":", "").replace(" ", "");
		return formattedTimeStamp;
	}

	public static void main(String[] args) {
		System.out.println("DateStamp : "+BaseTestHelper.currentDateStamp());
	}

}
