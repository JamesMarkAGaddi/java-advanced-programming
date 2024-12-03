package org.acumen.training.codes.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.acumen.training.codes.ChekcStr;
import org.acumen.training.codes.InvalidStringException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

public class TestChekcStr {

	private ChekcStr checkStr;

	@BeforeEach
	public void setup() {
		checkStr = new ChekcStr();
	}

	@AfterEach
	public void teardown() {
		checkStr = null;
	}

	@Test
	public void testConvertValidInput() {
		assertThrows(InvalidStringException.class, () -> {
			String result = checkStr.convert("4");
			assertEquals("100", result); 
		});
	}

	@Test
	public void testConvertEmptyInput() {		
		assertThrows(IllegalArgumentException.class, () -> {
			checkStr.convert("");
		});
	}

	@Test
	public void testTotalValidInput() {
		int result = checkStr.total("123");
		assertEquals(1 + 2 + 3, result); // Expect 6
	}

	@Test
	public void testTotalEmptyInput() {
		int result = checkStr.total(""); // Expect 0
		assertEquals(0, result);
	}

	@Test
	public void testBinariseZeroInput() {
		String result = checkStr.binarise(0);
		assertEquals("0", result); // Expect binary of 0 = "0"
	}

	@Test
	public void testBinariseValidInput() {
		String result = checkStr.binarise(15);
		assertEquals("1111", result); // Expect binary of 4 = "100"
	}

	@RepeatedTest(200)
	public void testBinariseCharInput() {
		String result = checkStr.binarise('a');
		assertEquals("1100001", result); // Expect binary of 0 = "0"
	}


	@Test
	public void testBinariseNegativeInput() {
		assertThrows(IllegalArgumentException.class, () -> {
			checkStr.binarise(-1); 
		});
	}

	@Test
	public void testBinariseRecursiveCases() {
		String result = checkStr.binarise(5);
		assertEquals("101", result); 
	}
}
