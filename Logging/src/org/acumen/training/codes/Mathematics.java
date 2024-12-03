package org.acumen.training.codes;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Mathematics {

	// traditional logging steps
	// Step 1: Setup a logger object
	private static final Logger LOGGER = Logger.getLogger(Mathematics.class.getName()); // it means one logger object
																						// per class kasi nakareflection
																						// lang ang logger dito
	// Step 2: Need magconfigure ng logger sa no args constructor
	// we only condigure our logger once

	public Mathematics() {
		LOGGER.setLevel(Level.WARNING); // info IS GENERIC SO PWEDE SYA SA MGA CATCH GANUN ERROR

		// Step 2a : create the format of the log
		try {
			FileHandler fileHandler = new FileHandler("./src/files/Mathematics.log", true);
			fileHandler.setLevel(Level.INFO);
			fileHandler.setEncoding("UTF-8");
			
			SimpleFormatter formatter = new SimpleFormatter();
			fileHandler.setFormatter(formatter);
			LOGGER.addHandler(fileHandler);
			// Step 2b Define log message
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	// Step 3: Perform the logging
	@SuppressWarnings("removal")
	public int add(int x, int y) throws NegativeOperandException {
		// put the log sa pinakaunang linya ng method call para di lunobo ang logging at start log sya
		LOGGER.info("start of add with params: %d %d".formatted(x,y));
		if (x < 0 || y < 0) {
			//error log kapag nagka error malalman
			LOGGER.severe("Negative x and y encountered ");
			throw new NegativeOperandException();
		}
		//result log for better tracking
		int sum =  x + y - 1;
		LOGGER.info("The sum is %d".formatted(sum));
		
		//warn log - kapag may mga @Supress warning line
		Integer bigSum = new Integer(sum);
		LOGGER.warning("used a deprecated Integer wrapping");
		
		//end log pag tapos na
		LOGGER.info("end of add()");
		return sum;
	}

	public int div(int x, int y) {

		return x / y;
	}
}
