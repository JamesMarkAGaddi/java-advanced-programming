package org.acumen.training.codes.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.acumen.training.codes.Mathematics2;
import org.acumen.training.codes.NegativeOperandException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;

public class TestMathematics2 {

	private Mathematics2 math2;

	@BeforeEach
	public void setup() {
		math2 = new Mathematics2();
	}

	@AfterEach
	public void teardown() {
		math2 = null;
	}

	@RepeatedTest(value = 100)
	public void testAdd() {
		int x = 10;
		int y = 20;
		int exp = 10;

		assertThrows(NegativeOperandException.class, () -> {
			int actual = math2.add(x, y);
			assertEquals(exp, actual);
		});
	}
}
