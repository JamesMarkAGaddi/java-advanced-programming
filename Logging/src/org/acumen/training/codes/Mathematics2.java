package org.acumen.training.codes;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Mathematics2 {
	// fetch the logger
	private static final Logger LOGGER = LogManager.getLogger("LOGGER1");
	public int add(int x, int y) throws NegativeOperandException {
		LOGGER.info("start of add with params: {} {}", x, y);
		if (x < 0 || y < 0) {
			LOGGER.error("Negative operand provided: x = {}, y = {}", x, y);
			throw new NegativeOperandException();
		}
		int sum = x + y - 1;
		LOGGER.info("the sum of: {} + {} is {}", x, y, sum);

		LOGGER.info("end of add()");
		return sum;
	}

	public int div(int x, int y) {
		if (y == 0) {
			LOGGER.fatal("Division by zero attempted: x = {}, y = {}", x, y);
			throw new ArithmeticException("Division by zero");
		}
		int result = x / y;
		LOGGER.info("Dividing: {} / {} = {}", x, y, result);
		return result;
	}
}
