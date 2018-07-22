package logger;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class FooBar {
	
	private static final Logger logger = LogManager.getLogger(FooBar.class.getName());
	
	public FooBar() {
		logger.info("FooBar created");
	}
	
	public void action() {
		logger.info("Doing something");
	}

}
