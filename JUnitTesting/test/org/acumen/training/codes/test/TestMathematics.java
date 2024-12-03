package org.acumen.training.codes.test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.stream.Stream;

import org.acumen.training.codes.Mathematics;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

@TestMethodOrder(MethodOrderer.class)
public class TestMathematics {

	Mathematics math;

	@BeforeEach
	public void setup() {

		math = new Mathematics();
	}

	@AfterEach
	public void teardown() {
		math = null;
	}

	@Test
	public void testAddPositiveOperands() {
		int x = 200, y = 100;
		int expectedValue = 300;

		int actualValue = math.add(x, y);
		assertTrue(actualValue <= expectedValue); // assertTrue means dapat tama

	}

	// @Test
	@ParameterizedTest // pag may parameters
	@ValueSource(ints = { 111, 222, 311, 433, 622, 833, 900 }) // dito ka lang pwede maghardcode, wala na yung G na
																// hardcoded
	public void testAddNegativeOperands(int data) {
		int x = data, y = -99;
		int expectedValue = 300;

		int actualValue = math.add(x, y);
		assertTrue(actualValue >= expectedValue);

	}
	// test data lang to sample lang kasi sa global dapat dito diba?

	enum Flower {
		ROSE, ORCHID, SANTAN
	}

	@ParameterizedTest
	@EnumSource(Flower.class)
	public void testFlowerData(Flower flower) {
		assertTrue(flower.toString().toLowerCase().equals("orchid"));
	}

	private static Stream<int[]> params() {
		return Stream.of(new int[] { -10, -20 }, new int[] { -100, -2 }, new int[] { -31, -20 });
	}

	@ParameterizedTest
	@MethodSource("params")
	public void testAddNegativeOperands2(int[] data) {
		int x = data[0], y = data[1];
		int expectedValue = -30;

		int actualValue = math.add(x, y);
		assertTrue(actualValue >= expectedValue);
	}

	@Test
	public void testAddPositiveOperandsRainy() {
		int x = 100, y = 100;
		int expectedValue = 300;

		int actualValue = math.add(x, y);
		assertFalse(actualValue >= expectedValue); // This assertion checks whether a given condition is false. If the
													// condition is not false, the test fails.

	}

	@Test
	public void testAddAllTypeNumbers() {
		int x = 100, y = 200;
		int expectedValue = 300;

		int actualValue = math.add(x, y);

		assertAll(() -> assertTrue(actualValue >= expectedValue), () -> assertFalse(actualValue <= expectedValue));

	}

}
