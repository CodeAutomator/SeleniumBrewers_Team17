package utilities;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
//LoggerLoad class provides logging capabilities using the Log4j library
public class LOGGER {
	
	/*
	 * The logger instance is created using the getLogger() method from the LogManager class, which returns a Logger object. 
	 * This logger object is used to log messages at different levels.
	 */
	
	private static Logger logger = LogManager.getLogger();

public static void info(String message) {
	//System.out.println("in info");
	logger.info(message);
	//System.out.println("in info after logging");
}
public static void warn(String message) {
	logger.warn(message);
}

public static void error(String message) {
	logger.info(message);
}
public static void fatal(String message) {
	logger.fatal(message);
}

public static void debug(String message) {
	logger.debug(message);
}


}
