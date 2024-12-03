package org.acumen.training.codes.test;

import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.junit.jupiter.api.Assertions.assertLinesMatch;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTimeout;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.Duration;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.acumen.training.codes.SavingsRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

//Test class
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

public class TestSavingsRepository {

	// test case scenarios - implemented in test methods
	// always public always void
	// no local param unless param testing
	// we annotate it

	// Best practice is one test scenario - one method call lang
	// bawal mga comparators at operators
	// bawal din ang loop
	// bawal mga if, switch case, branching, bawal mga programming kasi testing na
	// to

	// Fixtures - establishes the class that you wanna test, including the classes
	// you want to test
	// setup - yung nagiinstantiate or initailize
	// teardown - taganull ng nakadeclare na global objetcs, para syang grabage
	// collect
	private SavingsRepository repo; // private global mo na di naman gagamitin eh
//
//	@BeforeAll
//	public static void init() {
//		System.out.println("Start");
//	}
//
//	@AfterAll
//	public static void destroy() {
//		System.out.println("End");
//	}

	@BeforeEach // one lang neto per test class
	public void setup() {
		repo = new SavingsRepository();
		System.out.println("setup");
	}

	@AfterEach
	public void teardown() {
		repo = null;
		System.out.println("teardown");
	}

	@Disabled
	@Order(1)
	@Test
	public void testExecute() {
		repo.getMergedNames();
	}

	@Disabled // used kapag di na need gamitin yung test case na to
	@Order(2)
	@Test
	public void testExecuteTwo() {
		repo.welcome("James");
	}

	@Order(3)
	@Test
	public void testGetAccountSizeStart() {
		// GWT Method
		// GIVEN lahat ng mga inputs,
		int expectedValue = 0;

		// WHEN execution of methods
		int actualValue = repo.getAccountSize();

		// THEN is assertion, and then what?
		assertEquals(expectedValue, actualValue);
	}

	@Order(4)
	@Test
	public void testGetAccountSizeStartRainy() {
		// GWT Method
		// GIVEN lahat ng mga inputs,
		int expectedValue = 1;

		// WHEN execution of methods
		int actualValue = repo.getAccountSize();

		// THEN is assertion, and then what?
		assertNotEquals(expectedValue, actualValue);
	}

	// kapag may greaterthan na ganun di na equality iba na yung assert na gamit

	@Order(5)
	@Test
	public void testGetAccountSizeQuotaTenOrMore() {
		// GWT Method
		// GIVEN lahat ng mga inputs,

		List<String> names = Arrays.asList("Anna", "Lorna", "Fe", "Jose", "Mari", "Chan", "Jingle", " Bells", "Jingle",
				"AllTheWay");
		int expectedValue = 10;
		// WHEN execution of methods
		repo.setAccountHolders(names);
		int actualValue = repo.getAccountSize();

		// THEN is assertion, and then what?
		assertTrue(actualValue >= expectedValue, "Quota not met"); // failure to kasi may AssertionError sa outputs
	}

	@Order(6)
	@Test
	public void testGetAccountSizeQuotaTenOrMoreRainy() {
		// GWT Method
		// GIVEN lahat ng mga inputs,
		List<String> names = Arrays.asList("Anna", "Lorna", "Fe", "Jose", "Mari", "Chan", "Jingle", " Bells", "Jingle",
				"AllTheWay");
		int expectedValue = 3;
		// WHEN execution of methods
		repo.setAccountHolders(names);
		int actualValue = repo.getAccountSize();

		// THEN is assertion, and then what?
		assertFalse(actualValue <= expectedValue); // failure to kasi may AssertionError sa outputs
	}

	@Order(7)
	@Test
	public void testGetAccountHolders() {
		// GWT Method
		// GIVEN lahat ng mga inputs,
		List<String> names = Arrays.asList("Anna", "Lorna", "Fe", "Jose", "Mari", "Chan", "Jingle", " Bells", "Jingle",
				"AllTheWay");
		// WHEN execution of methods
		repo.setAccountHolders(names);
		List<String> res = repo.getAccountHolders();

		// THEN is assertion, and then what?
		assertNotNull(res);
	}

	@Order(8)
	@Test
	public void testGetAccountHoldersRainy() {
		// GWT Method
		// GIVEN lahat ng mga inputs,
		List<String> names = Arrays.asList("");
		// WHEN execution of methods
		repo.setAccountHolders(names);
		List<String> res = repo.getAccountHolders();

		// THEN is assertion, and then what?
		assertNotNull(res); // true dapat kasi wala namang laman pero dahil nag-instantiate ka sa una, may
							// empty List ka na
	}

	// for iterated testing like arrays na need magcheck by index
	@Order(9)
	@Test
	public void testGetAmountsPositiveInputs() {
		Double[] amounts = { 1000.0, 2000.0, 3000.0 };
		Double[] res = repo.getAmounts();

		for(Double r : res) {
			System.out.print(r);
		}

		assertArrayEquals(amounts, res);
	}

	// Multi-valued types
	public void testGetAmounts() {

	}

	@Order(10)
	@Test
	public void testGetAccountHoldersStart() {
		List<String> names = Arrays.asList("Anna", "Lorna", "Fe", "Jose", "Mari", "Chan", "Jingle", " Bells", "Jingle",
				"AllTheWay");

		repo.setAccountHolders(names);
		List<String> res = repo.getAccountHolders();

		assertIterableEquals(names, res);
	}

	// for checking the hashCode

	@Order(11)
	@Test
	public void testGetAccountHoldersSameObject() {
		List<String> names = new ArrayList<>();
		repo.setAccountHolders(names);

		List<String> res = repo.getAccountHolders();
		assertSame(names, res);

	}

	@Order(12)
	@Test
	public void testUpdateAccountDateInDays() { // dapat di to same kasi immutable ang Localdate since final sya
		int days = 15;
		LocalDate expectedObject = repo.now;

		LocalDate res = repo.updateAccountDate(days);
		assertNotSame(expectedObject, res);
	}

	// for type-checking like instanceOf()

	@Order(13)
	@Test
	public void testGetAmountsType() {
		var data = repo.getAmounts();

		assertInstanceOf(Double[].class, data);
	}

	@Disabled
	@Order(14)
	@Test
	public void testGetAmountsTypeRainy() {
		var data = repo.getAmounts();

		assertInstanceOf(Integer[].class, data); // should be false
	}

	@Order(15)
	@Test
	public void testNowParentTypeParent() {
		assertInstanceOf(LocalDate.class, repo.now);
	}

	@Order(16)
	@Test
	public void testNowParentTypeObject() {
		assertInstanceOf(Object.class, repo.now);
	}

	@Order(17)
	@Test
	public void testGetAccountsHoldersSamePerString() {
		List<String> names = Arrays.asList("Anna", "Lorna", "Fe", "Jose", "Mari", "Chan", "Jingle", " Bells", "Jingle",
				"AllTheWay");

		repo.setAccountHolders(names);
		List<String> res = repo.getAccountHolders(); // may toUpperCase na kasi rito sa method kaya false sya nyan

		assertLinesMatch(names, res);
	}

	@Order(18)
	@RepeatedTest(30) //used para magrun to paulit-ulit
	public void testGetAccountHoldersTimeOut() {
		List<String> names = Arrays.asList("Anna", "Lorna", "Fe", "Jose", "Mari", "Chan", "Jingle", " Bells", "Jingle",
				"AllTheWay");

		int millis = 1000;

		assertTimeout(Duration.of(millis, ChronoUnit.MILLIS), () -> {
			repo.setAccountHolders(names);
			repo.getAccountHolders();
		});
	}

	// exception testing - need mo ng mga exceptions talaga try-catch
	// the old-ways

	@Order(19)
	@Test
	public void testGetAccountHoldersDefault() {
		List<String> names = Arrays.asList("Anna", "Lorna", "Fe", "Jose", "Mari", "Chan", "Jingle", " Bells", "Jingle",
				"AllTheWay");

		try {

			List<String> res = repo.getAccountHolders(); // may toUpperCase na kasi rito sa method kaya false sya nyan
			assertNotNull(res);
		} catch (Exception e) {
			fail("The developer did not catch Exception");
		}
	}

	// the new-way

	@Order(20)
	@Test
	public void testGetAccountHoldersException() {
		List<String> names = Arrays.asList("Anna", "Lorna", "Fe", "Jose", "Mari", "Chan", "Jingle", " Bells", "Jingle",
				"AllTheWay");

		assertDoesNotThrow(() -> {
			List<String> res = repo.getAccountHolders(); // may toUpperCase na kasi rito sa method kaya false sya nyan
			assertNotNull(res);
		});
	}

	@Order(21)
	@Test
	public void testGetAccountHoldersExceptionRainy() {
		List<String> names = Arrays.asList("Anna", "Lorna", "Fe", "Jose", "Mari", "Chan", "Jingle", " Bells", "Jingle",
				"AllTheWay");

		assertThrows(NullPointerException.class, () -> {
			List<String> res = repo.getAccountHolders(); // may toUpperCase na kasi rito sa method kaya false sya nyan
			assertNotNull(res);
		});
	}

}
