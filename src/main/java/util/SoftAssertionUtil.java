package util;

import org.testng.asserts.SoftAssert;

public class SoftAssertionUtil {

	private SoftAssert softAssert;
	private SoftAssertionUtil() {}
	
	public static SoftAssertionUtil getInstance() {
		return new SoftAssertionUtil();
	}

	SoftAssert getSoftAssert() {
		if(softAssert==null) {
			softAssert = new SoftAssert();
		}
		return softAssert;
	}
	
	public boolean assertTrue(boolean condition, String message) {
		boolean status = false;
		try {
			getSoftAssert().assertTrue(condition, message);
			status = true;
		} catch (AssertionError e) {
			getSoftAssert().fail(message);
		}
		return status;
	}
	
}
