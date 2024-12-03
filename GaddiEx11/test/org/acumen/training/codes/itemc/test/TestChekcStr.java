package org.acumen.training.codes.itemc.test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.stream.Stream;

import org.acumen.training.codes.itemc.ChekcStr;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestChekcStr {
	ChekcStr ch;

	@BeforeEach
	public void setup() {
		ch = new ChekcStr();
		System.out.println("setup");
	}

	@AfterEach
	public void teardown() {
		ch = new ChekcStr();
		System.out.println("teardown");
	}

	@Order(1)
	@Test
	public void testBinarizeChekcStrAcceptsInput() {
		int inp = 1;
		assertNotNull(ch.binarise(inp));
	}

	@Order(2)
	@ParameterizedTest
	@ValueSource(ints = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 })
	public void testBinariseChekcStrZeroValidationForInts(int inp) {

		String expected = "";
		int x = inp;
		String actual = ch.binarise(x);

		assertNotEquals(expected, actual);
	}

	@Order(3)
	@ParameterizedTest
	@ValueSource(chars = { 'a', 'b', 'c', 'd', 'e' })
	public void testBinariseChekcStrZeroValidationForChars(char inp) {

		String expected = "";
		int x = inp;
		String actual = ch.binarise(x);

		assertNotEquals(expected, actual);
	}

	public record Input1(int number, String binaryString) {
	}

	private static Stream<Input1> inps1() {
		return Stream.of(new Input1(1, "1"), new Input1(2, "10"), new Input1(3, "11"), new Input1(4, "100"),
				new Input1(5, "101"), new Input1(6, "110"), new Input1(7, "111"), new Input1(8, "1000"),
				new Input1(9, "1001"), new Input1(10, "1010"));
	}

	@Order(4)
	@ParameterizedTest
	@MethodSource("inps1")
	public void testBinariseCheckStrNumInputs(Input1 input) {
		int inp = input.number();
		String expected = input.binaryString();

		String actual = ch.binarise(inp);
		assertEquals(expected, actual);
	}

	private static Stream<Input1> inps2() {
		return Stream.of(new Input1(1, "10"), new Input1(2, "01"), new Input1(3, "110"), new Input1(4, "101"),
				new Input1(5, "100"), new Input1(6, "101"), new Input1(7, "110"), new Input1(8, "0100"),
				new Input1(9, "1101"), new Input1(10, "1110"));
	}

	@Order(5)
	@ParameterizedTest
	@MethodSource("inps2")
	public void testBinariseCheckStrNumInputsRainy(Input1 input) {
		int inp = input.number();
		String expected = input.binaryString();

		String actual = ch.binarise(inp);
		assertNotEquals(expected, actual);
	}

	public record Input2(char let, String binaryString) {
	}

	private static Stream<Input2> inpsA() {
		return Stream.of(new Input2('a', "110 0001"), new Input2('b', "110 0010"), new Input2('c', "110 0011"),
				new Input2('d', "110 0100"), new Input2('e', "110 0101"));
	}

	@Order(6)
	@ParameterizedTest
	@MethodSource("inpsA")
	public void testBinariseCheckStrCharInputs(Input2 input) {
		char inp = input.let();
		String expected = input.binaryString();

		String actual = ch.binarise(inp);
		assertEquals(expected, actual);
	}

	private static Stream<Input2> inpsB() {
		return Stream.of(new Input2('a', "110 0101"), new Input2('b', "110 0110"), new Input2('c', "110 0111"),
				new Input2('d', "110 0000"), new Input2('e', "110 0111"));
	}

	@Order(7)
	@ParameterizedTest
	@MethodSource("inpsB")
	public void testBinariseCheckStrCharInputsRainy(Input2 input) {
		char inp = input.let();
		String expected = input.binaryString();

		String actual = ch.binarise(inp);
		assertNotEquals(expected, actual);
	}

	@Order(8)
	@Test
	public void testBinariseChekcStrOutputType() {

		int input = 1;
		String expectedBinary = "1";
		String binaryResult = ch.binarise(input);
		boolean isStringType = binaryResult instanceof String;

		assertAll(() -> assertTrue(isStringType, "The output should be of type String"),
				() -> assertEquals(expectedBinary, binaryResult,
						"The binary representation of the input should be correct."));
	}

	// Parameterized test for convert() method
	private static Stream<String[]> convertParams() {
		return Stream.of(new String[] { "", "" }, new String[] { null, "" },
				new String[] { "\n10001111\n", "111000111" }, new String[] { "1", "110001" },
				new String[] { "10", "1100001" });
	}

	@Order(9)
	@ParameterizedTest
	@MethodSource("convertParams")
	public void testConvertChekcStrOutput(String input, String expected) {
		String result = ch.convert(input);
		assertEquals(expected, result, "Convert should correctly return the binary string");
	}

	private static Stream<String[]> convertParamsRainy() {
		return Stream.of(new String[] { "", "\n" }, new String[] { null, null },
				new String[] { "\n10001111\n", "111000111\n" }, new String[] { "1", "1" },
				new String[] { "10", "1100000" });
	}

	@Order(10)
	@ParameterizedTest
	@MethodSource("convertParamsRainy")
	public void testConvertChekcStrOutputRainy(String input, String expected) {
		String result = ch.convert(input);
		assertNotEquals(expected, result, "Convert should not correctly return the binary string");
	}

	public record Input3(String inp, int expected) {
	}

	// Parameterized test for total() method
	private static Stream<Input3> totalParams() {
		return Stream.of(new Input3("", 0), // Empty string
				new Input3(null, 0), // Null String
				new Input3("\n10001111\n", 455), new Input3("1", 49), // ASCII value of '1'
				new Input3("10", 97) // ASCII values of '1' (49) + '0' (48)
		);
	}

	@Order(11)
	@ParameterizedTest
	@MethodSource("totalParams")
	public void testTotalChekcStrOutput(String input, int expected) {
		int result = ch.total(input);
		assertEquals(expected, result, "Total should be calculated correctly based on ASCII values");
	}

	private static Stream<Input3> totalParamsRainy() {
		return Stream.of(new Input3("", 1), // Empty string
				new Input3(null, 1), // Null String
				new Input3("\n10001111\n", 456), new Input3("1", 1), // ASCII value of '1'
				new Input3("10", 1) // ASCII values of '1' (49) + '0' (48)
		);
	}

	@Order(12)
	@ParameterizedTest
	@MethodSource("totalParamsRainy")
	public void testTotalChekcStrOutputRainy(String input, int expected) {
		int result = ch.total(input);
		assertNotEquals(expected, result, "Total should not be calculated correctly based on ASCII values");
	}

	@Order(13)
	@Test
	public void testConvertChekcStrOutputType() {

		String input = "100";
		String expected = "1";
		String StringResult = ch.convert(input);
		boolean isStringType = StringResult instanceof String;

		assertAll(() -> assertTrue(isStringType, "The output should be of type String"),
				() -> assertEquals(expected, StringResult));
	}

	@Order(14)
	@Test
	public void testTotalChekcIntOutputType() {

		String input = "2";
		int expected = 49;
		Integer intResult = ch.total(input);
		boolean isIntegerType = intResult instanceof Integer;

		assertAll(() -> assertTrue(isIntegerType, "The output should be of type Integer"),
				() -> assertEquals(expected, intResult));
	}

	@Order(15)
	@Test
	public void testBinariseChekcNotNulltOutputType() {

		int input = 1;
		String StringResult = ch.binarise(input);

		assertNotNull(StringResult, "Output should not be null");
	}

	@Order(16)
	@Test
	public void testConvertChekcNotNulltOutputType() {

		String input = "100";
		String StringResult = ch.convert(input);

		assertNotNull(StringResult, "Output should not be null");
	}

	@Order(17)
	@Test
	public void testTotalChekcNotNulltOutputType() {

		String input = "100";
		int intResult = ch.total(input);

		assertNotNull(intResult, "Output should not be null");
	}

	@Order(18)
	@Test
	public void testTotalChekcStrNullInput() {
		assertDoesNotThrow(() -> {
			ch.total(null);
		});
	}
	
	@Order(19)
	@Test
	public void testConvertChekcStrNullInput() {
		assertDoesNotThrow(() -> {
			ch.convert(null);
		});
	}
	
}
