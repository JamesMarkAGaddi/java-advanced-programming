package org.acumen.training.codes.itemb.test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.stream.Stream;

import org.acumen.training.codes.itemb.Calculator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

public class TestCalculator {

    private Calculator calculator;

    @BeforeEach
    public void setup() {
        calculator = new Calculator();
    }

    @AfterEach
    public void teardown() {
        calculator = null;
    }

    // a. Test methods checking if a string expression with 4 plus and 5 operands
    // each lower than 10 can give a result of not more than 20.
    
    @Order(1)
    @Test
    public void testEvaluateSumOperandsLowerThanTenNotMoreThanTwenty1() {
        String expression = "1+2+3+4+5";

        int result = calculator.evaluate(expression);
        
        assertTrue(result <= 20);
    }

    @Order(2)
    @Test
    public void testEvaluateSumOperandsLowerThanTenNotMoreThanTwenty2() {
        String expression = "0+2+4+6+8";
        
        int result = calculator.evaluate(expression);
        
        assertTrue(result <= 20);
    }

    @Order(3)
    @Test
    public void testEvaluateSumOperandsLowerThanTenNotMoreThanTwenty3() {
        String expression = "3+3+3+2+1";
        
        int result = calculator.evaluate(expression);
        
        assertTrue(result <= 20);
    }

    @Order(4)
    @Test
    public void testEvaluateSumOperandsLowerThanTenNotMoreThanTwenty4() {
        String expression = "5+5+5+5+5";
        
        int result = calculator.evaluate(expression);
        
        assertTrue(result <= 20);
    }

    // b. Test methods checking if a string expression with 4 plus and 5 operands
    // all negative numbers not lower than -10 can give a result lower than or equal
    // to -10.
    
    @Order(5)
    @Test
    public void testEvaluateNegativeOperandsNotLowerThanNegativeTen1() {
        String expression = "-1+-2+-3+-4+-5";
        
        int result = calculator.evaluate(expression);
        
        assertTrue(result <= -10);
    }

    @Order(6)
    @Test
    public void testEvaluateNegativeOperandsNotLowerThanNegativeTen2() {
        String expression = "-5+-5+-5+-5+-5";
        
        int result = calculator.evaluate(expression);
        
        assertTrue(result <= -10);
    }

    @Order(7)
    @Test
    public void testEvaluateNegativeOperandsNotLowerThanNegativeTen3() {
        String expression = "-10+-9+-8+-7+-6";
        
        int result = calculator.evaluate(expression);
        
        assertTrue(result <= -10);
    }

    @Order(8)
    @Test
    public void testEvaluateNegativeOperandsNotLowerThanNegativeTen4() {
        String expression = "-2+-3+-4+-5+-6";
        
        int result = calculator.evaluate(expression);
        
        assertTrue(result <= -10);
    }

    // c. Exception testing with expressions containing minus and multiplication
    // symbols
    
    @Order(9)
    @Test
    public void testEvaluateExpressionWithInvalidCharactersThrows() {
        String expression = "2+3*4-5";
        
        assertThrows(NumberFormatException.class, () -> {
            calculator.evaluate(expression);
        });
    }

    // d. Parameterized testing with 10 expressions with varying scenarios
    public record Format(String inp, int out) {}
    
	private static Stream<Format> params(){
		return Stream.of(
				new Format("1+1", 2),
				new Format("-1+1",0), 
				new Format("0+0", 0), 
				new Format("5+10", 15),
				new Format("-5+-5+-5+-5+-5", -25), 
				new Format("3+3+3+3", 12), 
				new Format("2+2", 0), 
				new Format("0+1",1),
				new Format("-10+5", -5), 
				new Format("10+20+30+40", 100));
	}

    @Order(10)
	@ParameterizedTest
	@MethodSource("params")
	public void testEvaluateVariousExpressions(Format nums) {
		String inp = nums.inp();
		int res = calculator.evaluate(inp);
		int out = nums.out();

		assertEquals(out, res);
	}

    // e. Proposed tests for evaluate() algorithm
    
    @Order(11)
    @Test
    public void testEvaluateEmptyInputThrowsIllegalErgument() {
        String input = "";
    
        assertThrows(IllegalArgumentException.class, () -> {
            calculator.evaluate(input);
        });
    }

    @Order(12)
    @Test
    public void testEvaluateEmptyInputDoesNotThrowsIllegalArgument() {
        String input = "";
        
        assertDoesNotThrow(() -> {
            calculator.evaluate(input);
        }, "Expected evaluate() to throw IllegalArgumentException, but it didn't");
    }

    @Order(13)
    @Test
    public void testEvaluateNullInputThrowsNull() {
        String input = null;
        
        assertThrows(NullPointerException.class, () -> {
            calculator.evaluate(input);
        });
    }

    @Order(14)
    @Test
    public void testEvaluateNullInputDoesNotThrowsNull() {
        String input = null;
        
        assertDoesNotThrow(() -> { 
        	calculator.evaluate(input);
        }, "Expected evaluate() to throw NullPointerException, method should return -1000");
    }

    @Order(15)
    @Test
    public void testEvaluateWrongInput() {
        String input = "1+a+3";
        
        assertThrows(NumberFormatException.class, () -> {
            calculator.evaluate(input);
        }, "Expected evaluate() to throw, but it didn't");
    }
    
    @Order(16)
    @Test
    public void testEvaluateEmptyInputDoesNotNumerFormat() {
        String input = "1+a+3";
        
        assertDoesNotThrow(() -> {
            calculator.evaluate(input);
        }, "Expected evaluate() to throw NumberFormatExceptions, method should return -2000");
    }
    
    @Order(17)
    @Test
    public void testEvaluateSubtractExpr() {
        String input = "1000-4000";
        
        assertDoesNotThrow(() -> {
            calculator.evaluate(input);
        }, "Expected evaluate() to throw NumberFormatExceptions, method should return -3000");
    }

    @Order(18)
    @Test
    public void testEvaluateMultiplyExpr() {
        String input = "1000*4000";
        
        assertDoesNotThrow(() -> {
            calculator.evaluate(input);
        }, "Expected evaluate() to throw NumberFormatExceptions, method should return -4000");
    }
    
    @Order(19)
    @Test 
    public void testEvaluateOutputInstance() {
    	String input = "223+69";
    	
    	int res = calculator.evaluate(input);
    	
    	assertInstanceOf(Integer.class, res);    	
    }
}
