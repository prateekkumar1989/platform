package logger;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LogRunner {
	
	static {
        System.setProperty("log4j.configurationFile", "resources/configuration.xml");
    }
	private static final Logger logger = LogManager.getLogger("LogRunner");
	
	public static void main(String[] args) {
		logger.info("LogRunner");
		FooBar foobar = new FooBar();
		foobar.action();
		
	}

}
