package core;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class OutputLog {

	private static Logger logger;
	//private static final String logFilename = "OutputLog_ALL_" + BaseTestHelper.currentDateStamp() + ".log";
	
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
