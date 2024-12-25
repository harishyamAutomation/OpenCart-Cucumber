package core;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class OutputLog {

	private static Logger logger;
	//private static final String logFilename = "OutputLog_ALL_" + BaseTestHelper.currentDateStamp() + ".log";
	
	private static String getFullExceptionDetails(Exception e) {
        // Capture the exception message and stack trace
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        e.printStackTrace(pw);
        
        // Build a detailed exception message
        StringBuilder exceptionDetails = new StringBuilder();
        exceptionDetails.append(e.toString()).append("\n"); // Include exception message
        exceptionDetails.append(sw.toString()); // Include stack trace
        return exceptionDetails.toString();
    }
	
	//Log INFO message
	public static void info(String message) {
		logger = LogManager.getLogger(Thread.currentThread().getStackTrace()[2].getClassName());
		logger.info(message);
	}

	//Log ERROR message
	public static void error(String message) {
		logger = LogManager.getLogger(Thread.currentThread().getStackTrace()[2].getClassName());
		logger.error(message);
	}
	
	//Log ERROR with complete exception details
	public static void error(Exception e) {
		logger = LogManager.getLogger(Thread.currentThread().getStackTrace()[2].getClassName());
		logger.error(getFullExceptionDetails((Exception) e));
	}
	
	//Log ERROR with message & complete exception details
	public static void error(String message, Exception e) {
		logger = LogManager.getLogger(Thread.currentThread().getStackTrace()[2].getClassName());
		logger.error(message);
		logger.error(getFullExceptionDetails(e));
	}

	//Log DEBUG message
	public static void debug(String message) {
		logger = LogManager.getLogger(Thread.currentThread().getStackTrace()[2].getClassName());
		logger.debug(message);
	}

	//Log WARN message
	public static void warn(String message) {
		logger = LogManager.getLogger(Thread.currentThread().getStackTrace()[2].getClassName());
		logger.warn(message);
	}

	//Log FATAL message
	public static void fatal(String message) {
		logger = LogManager.getLogger(Thread.currentThread().getStackTrace()[2].getClassName());
		logger.fatal(message);
	}

}
