package org.acumen.training.codes;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SimpleApp {
	 private static final Logger LOGGER = LogManager.getLogger("SimpleApp"); 
	public int returnOne() {
        LOGGER.info("Here's One!");
		return 1;
	}

	public static void main(String[] args) {
        LOGGER.info("Start of main(String[] args)");
        LOGGER.info("End ofmain(String[] args)");
	}
}
