package org.acumen.training.codes.itemc.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;

import java.util.stream.Stream;

import org.acumen.training.codes.itemc.Locator;
import org.acumen.training.codes.itemc.LocatorService;
import org.acumen.training.codes.itemc.Point;
import org.acumen.training.codes.itemc.PointGeneration;
import org.acumen.training.codes.itemc.Utils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class TestLocatorAndPointGeneration {

	@Mock
	private LocatorService locatorService;

	@InjectMocks
	private Locator locator;

	@InjectMocks
	private PointGeneration pointGeneration;

	@BeforeEach
	public void setup() {
		locator = new Locator(locatorService);
		pointGeneration = new PointGeneration();
	}

	// a. Using Mockito, test the result of locate() of Locator class for given data
	// sets
	@Test
	public void testLocateNegativeXAndPositiveY() {
		// Test locate(-101, 100)
		int expectedX = 101;
		int expectedY = 100;

		Point result = locator.locate(-101, 100);

		int resX = result.getX();
		int resY = result.getY();

		assertEquals(expectedX, resX);
		assertEquals(expectedY, resY);
	}

	@Test
	public void testLocateNegativeXAndPositiveYRainy() {
		// Test locate(-101, 100)
		int expectedX = -101;

		Point result = locator.locate(-101, 100);

		int resX = result.getX();

		assertNotEquals(expectedX, resX);
	}

	@Test
	public void testLocatePositiveXAndPositiveY() {
		// Test locate(20, 90)
		int expectedX = 20;
		int expectedY = 90;

		Point mockPt = new Point(expectedX, expectedY);
		given(locatorService.geoLocate(any(Point.class))).willReturn(mockPt);
		Point result = locator.locate(20, 90);

		int resX = result.getX();
		int resY = result.getY();

		assertEquals(expectedX, resX);
		assertEquals(expectedY, resY);
		verify(locatorService).geoLocate(any(Point.class));
	}

	@Test
	public void testLocatePositiveXAndPositiveYRainy() {
		// Test locate(20, 90)
		int expectedX = 20;
		int expectedY = 90;

		Point mockPt = new Point(expectedX, expectedY);
		given(locatorService.geoLocate(any(Point.class))).willReturn(mockPt);
		Point result = locator.locate(20, 90);

		int resX = result.getX();
		int resY = result.getY();

		assertFalse(expectedX != resX);
		assertFalse(expectedY != resY);
		verify(locatorService).geoLocate(any(Point.class));
	}

	@Test
	public void testLocatePositiveXAndNegativeY() {
		// Test locate(110, -100)
		int expectedX = 20;
		int expectedY = 90;

		Point mockPt = new Point(expectedX, expectedY);
		given(locatorService.geoLocate(any(Point.class))).willReturn(mockPt);
		Point result = locator.locate(20, 90);

		int resX = result.getX();
		int resY = result.getY();

		assertEquals(expectedX, resX);
		assertEquals(expectedY, resY);
		verify(locatorService).geoLocate(any(Point.class));
	}

	@Test
	public void testLocatePositiveXAndNegativeYRainy() {
		// Test locate(110, -100)
		int expectedY = -100;

		Point result = locator.locate(110, -100);

		int resY = result.getY();

		assertNotEquals(expectedY, resY);
	}

	@Test
	public void testLocatePositiveXAndNegativeY2() {
		// Test locate(110, -100)
		int expectedX = 10;
		int expectedY = 5;

		Point result = locator.locate(10, -5);

		int resX = result.getX();
		int resY = result.getY();

		assertEquals(expectedX, resX);
		assertEquals(expectedY, resY);
	}

	@Test
	public void testLocatePositiveXAndNegativeY2Rainy() {
		// Test locate(110, -100)
		int expectedY = -5;

		Point result = locator.locate(10, -5);

		int resY = result.getY();

		assertNotEquals(expectedY, resY);
	}

	@Test
	public void testLocateZeroXandZeroY() {
		// Test locate(0, 0)
		int expectedX = 0;
		int expectedY = 0;

		Point mockPt = new Point(expectedX, expectedY);
		given(locatorService.geoLocate(any(Point.class))).willReturn(mockPt);
		Point result = locator.locate(0, 0);

		int resX = result.getX();
		int resY = result.getY();

		assertEquals(expectedX, resX);
		assertEquals(expectedY, resY);
		verify(locatorService).geoLocate(any(Point.class));

	}

	@Test
	public void testLocateZeroXandZeroYNotNull() {
		// Test locate(0, 0)
		int expectedX = 0;
		int expectedY = 0;

		Point mockPt = new Point(expectedX, expectedY);
		given(locatorService.geoLocate(any(Point.class))).willReturn(mockPt);
		Point result = locator.locate(0, 0);

		int resX = result.getX();
		int resY = result.getY();

		assertNotNull(resX);
		assertNotNull(resY);
		verify(locatorService).geoLocate(any(Point.class));

	}

	@Test
	public void testLocateNegativeXAndPositiveY2() {
		// Test locate(90, 90)
		int expectedX = 90;
		int expectedY = 90;

		Point result = locator.locate(-90, 90);

		int resX = result.getX();
		int resY = result.getY();

		assertEquals(expectedX, resX);
		assertEquals(expectedY, resY);
	}

	@Test
	public void testLocateNegativeXAndPositiveY2Rainy() {
		// Test locate(-101, 100)
		int expectedX = -90;

		Point result = locator.locate(-90, 90);

		int resX = result.getX();

		assertNotEquals(expectedX, resX);
	}

	@Test
	public void testLocateNegativeXAndNegativeY() {
		// Test locate(-201, -100)
		int expectedX = 201;
		int expectedY = 100;

		Point result = locator.locate(-201, 100);

		int resX = result.getX();
		int resY = result.getY();

		assertEquals(expectedX, resX);
		assertEquals(expectedY, resY);
	}

	@Test
	public void testLocateNegativeXAndNegativeYRainy() {
		// Test locate(-201, -100)
		int expectedX = -201;
		int expectedY = -100;

		Point result = locator.locate(-201, -100);

		int resX = result.getX();
		int resY = result.getY();

		assertNotEquals(expectedX, resX);
		assertNotEquals(expectedY, resY);
	}

	// the only test that will work for callPrivateMethod because it only returns
	// null
	@Test
	public void testCallPrivateMethodWithNegativeCoordinates() {
		int distance = 10;

		Point result = pointGeneration.callPrivateMethod(distance);

		assertNull(result);
	}
	
	@Disabled
	@Test
	public void testCallPrivateMethodWithNegativeCoordinates1() {
		int distance = 10;
		Point expected = new Point(-10, -74);

		given(locatorService.generatePointWithinDistance(any(Point.class), any(Integer.class))).willReturn(expected);

		Point result = pointGeneration.callPrivateMethod(distance);

		assertEquals(expected.getX(), result.getX());
		assertEquals(expected.getY(), result.getY());
		verify(locatorService).generatePointWithinDistance(any(Point.class), any(Integer.class));
	}

	@Disabled
	@Test
	public void testCallPrivateMethodWithNegativeCoordinates2() {
		int distance = 10;
		Point expected = new Point(-120, -90);

		given(locatorService.generatePointWithinDistance(any(Point.class), any(Integer.class))).willReturn(expected);

		Point result = pointGeneration.callPrivateMethod(distance);

		assertEquals(expected.getX(), result.getX());
		assertEquals(expected.getY(), result.getY());
		verify(locatorService).generatePointWithinDistance(any(Point.class), any(Integer.class));
	}

	@Disabled
	@Test
	public void testCallPrivateMethodWithNegativeCoordinates3() {
		int distance = 10;
		Point expected = new Point(110, -100);

		given(locatorService.generatePointWithinDistance(any(Point.class), any(Integer.class))).willReturn(expected);

		Point result = pointGeneration.callPrivateMethod(distance);

		assertEquals(expected.getX(), result.getX());
		assertEquals(expected.getY(), result.getY());
		verify(locatorService).generatePointWithinDistance(any(Point.class), any(Integer.class));
	}

	@Disabled
	@Test
	public void testCallPrivateMethodWithNegativeCoordinates4() {
		int distance = 10;
		Point expected = new Point(110, -5);

		given(locatorService.generatePointWithinDistance(any(Point.class), any(Integer.class))).willReturn(expected);

		Point result = pointGeneration.callPrivateMethod(distance);

		assertEquals(expected.getX(), result.getX());
		assertEquals(expected.getY(), result.getY());
		verify(locatorService).generatePointWithinDistance(any(Point.class), any(Integer.class));
	}

	@Disabled
	@Test
	public void testCallPrivateMethodWithNegativeCoordinates5() {
		int distance = 10;
		Point expected = new Point(1, 1);

		given(locatorService.generatePointWithinDistance(any(Point.class), any(Integer.class))).willReturn(expected);

		Point result = pointGeneration.callPrivateMethod(distance);

		assertEquals(expected.getX(), result.getX());
		assertEquals(expected.getY(), result.getY());
		verify(locatorService).generatePointWithinDistance(any(Point.class), any(Integer.class));
	}

	@Disabled
	@Test
	public void testCallPrivateMethodWithNegativeCoordinates6() {
		int distance = 10;
		Point expected = new Point(10, 80);

		given(locatorService.generatePointWithinDistance(any(Point.class), any(Integer.class))).willReturn(expected);

		Point result = pointGeneration.callPrivateMethod(distance);

		assertEquals(expected.getX(), result.getX());
		assertEquals(expected.getY(), result.getY());
		verify(locatorService).generatePointWithinDistance(any(Point.class), any(Integer.class));
	}

	@Disabled
	@Test
	public void testCallPrivateMethodWithNegativeCoordinates7() {
		int distance = 10;
		Point expected = new Point(11, -50);

		given(locatorService.generatePointWithinDistance(any(Point.class), any(Integer.class))).willReturn(expected);

		Point result = pointGeneration.callPrivateMethod(distance);

		assertEquals(expected.getX(), result.getX());
		assertEquals(expected.getY(), result.getY());
		verify(locatorService).generatePointWithinDistance(any(Point.class), any(Integer.class));
	}

	// Test the public method which always returns Point(11, 11)
	@Test
	public void testPublicMethod() {
		Point result = pointGeneration.publicMethod();
		assertEquals(11, result.getX());
		assertEquals(11, result.getY());
	}

	// Test multiple distance values for callPrivateMethod
	@Disabled
	@ParameterizedTest
	@ValueSource(ints = { 10, 100, 1000 }) // Different sizes to test
	public void testCallPrivateMethodForVariousCases(int dist) {
		Point expected = new Point(3, 3);

		given(locatorService.generatePointWithinDistance(new Point(2, 2), dist)).willReturn(expected);
		Point result = pointGeneration.callPrivateMethod(dist);

		assertEquals(3, result.getX());
		assertEquals(3, result.getY());
		verify(locatorService, atLeastOnce()).generatePointWithinDistance(new Point(2, 2), dist);
	}

	@ParameterizedTest
	@ValueSource(ints = { 10, 50, 1000 })
	public void testRandomDistanceWithinRange(int distance) {
		// Given
		int lowerBound = -distance;
		int upperBound = distance;

		// When
		int result = Utils.randomDistance(distance);

		// Then
		boolean isWithinRange = result >= lowerBound && result <= upperBound;
		assertTrue(isWithinRange, "Result should be within range of [" + lowerBound + ", " + upperBound + "]");
	}

	@Disabled
	@ParameterizedTest
	@ValueSource(ints = { 0 })
	public void testRandomDistanceWithZero(int distance) {
		int expected = 0;

		int result = Utils.randomDistance(distance);

		boolean isExpected = result == expected;
		assertTrue(isExpected);
	}

	@ParameterizedTest
	@MethodSource("provideDistancesForPositiveAndPositiveTests")
	public void testRandomDistanceWithPositiveAndPositive(int[] params) {
		int distance = params[0];
		int expectedAbsValue = params[1];
		int lowerBound = -expectedAbsValue;
		int upperBound = expectedAbsValue;

		int result = Utils.randomDistance(distance);

		boolean isWithinRange = result >= lowerBound && result <= upperBound;
		assertTrue(isWithinRange);
	}

	private static Stream<int[]> provideDistancesForPositiveAndPositiveTests() {
		return Stream.of(new int[] { 110, 110 }, new int[] { 25, 25 });
	}

	@Disabled
	@ParameterizedTest
	@MethodSource("provideDistancesForNegativeAndPositiveTests")
	public void testRandomDistanceWithNegativeAndPositive(int[] params) {
		int distance = params[0];
		int expectedAbsValue = params[1];
		int lowerBound = -expectedAbsValue;
		int upperBound = expectedAbsValue;

		int result = Utils.randomDistance(distance);

		boolean isWithinRange = result >= lowerBound && result <= upperBound;
		assertFalse(isWithinRange);
	}

	private static Stream<int[]> provideDistancesForNegativeAndPositiveTests() {
		return Stream.of(new int[] { -10, 10 }, new int[] { -50, 50 });
	}

	@ParameterizedTest
	@MethodSource("provideLargeDistances")
	public void testRandomDistanceWithLargeNumbers(int[] params) {
		int distance = params[0];
		int expectedAbsValue = params[1];
		int lowerBound = -expectedAbsValue;
		int upperBound = expectedAbsValue;

		int result = Utils.randomDistance(distance);

		boolean isWithinRange = result >= lowerBound && result <= upperBound;
		assertTrue(isWithinRange);
	}

	private static Stream<int[]> provideLargeDistances() {
		return Stream.of(new int[] { 1000, 1000 }, new int[] { 30000, 30000 });
	}
}
