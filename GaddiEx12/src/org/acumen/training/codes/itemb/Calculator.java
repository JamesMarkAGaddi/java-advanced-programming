package org.acumen.training.codes.itemb;

public class Calculator {
	
	public int evaluate(String expression) {
		int sum = 0;
		for (String summand : expression.split("\\+"))
			sum += Integer.valueOf(summand);
		return sum;
	}
}