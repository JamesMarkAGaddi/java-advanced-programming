package org.acumen.training.codes.itema.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

import org.acumen.training.codes.itema.Product;
import org.acumen.training.codes.itema.ProductNotFoundException;
import org.acumen.training.codes.itema.ShoppingCart;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class TestShoppingCart {

	@Mock
	private Product prod;
	Product product1;
	Product product2;

	@InjectMocks
	private ShoppingCart cart;

	@BeforeEach
	public void setup() {
		cart = new ShoppingCart();
	}

	@AfterEach
	public void teardown() {
		cart = null;
	}

	// testCreateCart() – test that will show that when cart is created, the cart
	// has 0 items
	@Test
	public void testCreateCart() {
		int expected = 0;

		int items = cart.getItemCount();

		assertEquals(expected, items);

	}

	@Test
	public void testCreateCartMoreThanZeroItems() {
		int expected = 0;

		int items = cart.getItemCount();

		assertFalse(items > expected);

	}

	@Test
	public void testCreateCartLessThanZeroItems() {
		int expected = 0;

		int items = cart.getItemCount();

		assertFalse(items < expected);

	}

	@Test
	public void testCreateCartIntOutput() {

		int items = cart.getItemCount();

		assertInstanceOf(Integer.class, items);

	}

	@Test
	public void testCreateCartNotNullOutput() {

		assertNotNull(cart);

	}

	// Test for balance when the cart is empty
	@Test
	public void testGetBalanceEmptyCartInitialization() {
		double expected = 0.0;

		double actual = cart.getBalance();

		assertEquals(expected, actual);
	}

	@Test
	public void testGetBalanceEmptyCartInitializationMoreThanZeroBalance() {
		double expected = 0.0;

		double actual = cart.getBalance();

		assertFalse(actual > expected);

	}

	@Test
	public void testGetBalanceEmptyCartInitializationLessThanZeroBalance() {
		double expected = 0.0;

		double actual = cart.getBalance();

		assertFalse(actual < expected);

	}

	@Test
	public void testGetbalanceDoubleOutput() {

		double actual = cart.getBalance();

		assertInstanceOf(Double.class, actual);

	}

	// testEmptyCart() – test that will show that when cart is emptied, the cart has
	// 0 items
	@Test
	public void testEmptyCart() {
		int expected = 0;

		cart.addItem(prod); // Add a product to cart
		cart.empty();
		int items = cart.getItemCount();

		assertEquals(expected, items);

	}

	@Test
	public void testEmptyCartNotNull() {

		cart.addItem(prod); // Add a product
		cart.empty();
		int items = cart.getItemCount();

		assertNotNull(items);

	}

	// Test for balance when the cart is empty
	@Test
	public void testGetBalanceEmptyCartAfterEmpty() {
		double expected = 0.0;

		cart.addItem(prod);
		cart.empty();
		double actual = cart.getBalance();

		assertEquals(expected, actual);
	}

	// testAddProduct() – test that will show that when a new product is added, the
	// number of items is incremented
	@Test
	public void testAddProduct() {
		int expected = 1;

		given(prod.getPrice()).willReturn(100.0);
		cart.addItem(prod);
		int items = cart.getItemCount();

		assertEquals(expected, items);
		verify(prod).getPrice();

	}

	// testAddProductNewBalance() – test case that will that when a new product is
	// added, the new balance must be the sum of the previous balance plus the cost
	// of the new product
	@Test
	public void testAddProductNewBalance() {
		double expected = 200.0;

		given(prod.getPrice()).willReturn(100.0);
		cart.addItem(prod);
		cart.addItem(prod);
		double balance = cart.getBalance();

		assertEquals(expected, balance);
	}

	// testDeleteProduct() – test case that will show that when an item is removed,
	// the number of items must be decreased
	@Test
	public void testDeleteProduct() { // for double checking

		int expected = 0;

		cart.addItem(prod);
		try {
			cart.removeItem(prod);
		} catch (ProductNotFoundException e) {
			e.printStackTrace();
		}

		int items = cart.getItemCount();
		assertEquals(expected, items);

	}

	@Test
	public void testDeleteProductVerifyPriceCalled() {
		given(prod.getPrice()).willReturn(100.0);
		cart.addItem(prod);

		try {
			cart.removeItem(prod);
		} catch (ProductNotFoundException e) {
			e.printStackTrace();
		}

		verify(prod, atLeastOnce()).getPrice();
	}

	// testDeleteproductDoesNotExists() – test that will show that when a product
	// not in the
	// cart is removed, a ProductNotFoundException must be thrown.
	@Test
	public void testDeleteproductDoesNotExist() { // for double checking

		assertThrows((ProductNotFoundException.class), () -> {
			cart.removeItem(prod);
		});

	}

	@Test
	public void testDeleteProductDoesNotExistVerifyPriceNotCalled() {

		assertThrows(ProductNotFoundException.class, () -> {
			cart.removeItem(prod);
		});

		verify(prod, never()).getPrice(); // Ensure getPrice() is not called
	}

	// Test for removing an item from an empty cart
	@Test
	public void testRemoveItemFromEmptyCart() {

		assertThrows(ProductNotFoundException.class, () -> cart.removeItem(prod));
	}

	// Test cart state consistency after failed removal
	@Test
	public void testCartStateAfterFailedRemoval() { // for double checking
		int expected = 1;
		Product nonExisting = new Product("Non-Existent", 50.0);

		given(prod.getPrice()).willReturn(100.0);
		cart.addItem(prod);
		assertThrows(ProductNotFoundException.class, () -> cart.removeItem(nonExisting));

		assertEquals(expected, cart.getItemCount()); // Ensure original product is still in the cart
	}

	@Test
	public void testCartStateAfterFailedRemovalSVerifyPriceCalled() {
		Product nonExisting = new Product("Non-Existent", 50.0);

		given(prod.getPrice()).willReturn(100.0);
		cart.addItem(prod);

		assertThrows(ProductNotFoundException.class, () -> cart.removeItem(nonExisting));

		verify(prod, atLeastOnce()).getPrice(); // Ensure price is still accessed for the added product
	}

	@Test
	public void testCartStateAfterFailedRemovalSVerifyPriceCalledShouldCallNullPointerException() {
		Product nonExisting = new Product("Non-Existent", 50.0);

		try {
			cart.addItem(prod);
			cart.removeItem(nonExisting);
		} catch (Exception e) {
			fail("The developer did not catch Exception");
		}

		verify(prod, atLeastOnce()).getTitle();
	}

	// Verify that Product's getPrice() was called when balance is checked
	@Test
	public void testVerifyProductPriceCalled() {

		given(prod.getPrice()).willReturn(100.0);
		cart.addItem(prod);
		cart.getBalance();
		verify(prod).getPrice(); // Ensure getPrice() was called
	}

	@Test
	public void testProductEqualsSunny() {
		product1 = new Product("Product1", 100.0);
		product2 = new Product("Product1", 150.0);

		cart.addItem(product1);
		cart.addItem(product2);
		assertTrue(product1.equals(product2), "Products with the same title should be considered equal.");
	}

	@Test
	public void testProductNotEqualsRainy() {
		product1 = new Product("Product1", 100.0);
		product2 = new Product("Product2", 150.0);

		cart.addItem(product1);
		cart.addItem(product2);
		assertFalse(product1.equals(product2), "Products with different titles should not be considered equal.");
	}

	// Parameterized test for adding many products
	@ParameterizedTest
	@ValueSource(ints = { 10, 100, 1000 }) // Different sizes to test
	public void testAddManyProducts(int numberOfProducts) {

		for (int i = 0; i < numberOfProducts; i++) {
			cart.addItem(prod);
		}

		assertEquals(numberOfProducts, cart.getItemCount());

	}

	@ParameterizedTest
	@ValueSource(ints = { 10, 100, 1000 }) // Different sizes to test
	public void testAddManyProductsTotalBalance(int numberOfProducts) {
		given(prod.getPrice()).willReturn(100.0);
		double expected = numberOfProducts * prod.getPrice();

		for (int i = 0; i < numberOfProducts; i++) {
			cart.addItem(prod);
		}
		double total = cart.getBalance();

		assertEquals(expected, total);

	}

}

//Cart Creation Tests:
//testCreateCart: Verifies that a newly created cart has 0 items.
//testCreateCartMoreThanZeroItems: Confirms that the item count is not greater than 0 for a new cart.
//testCreateCartLessThanZeroItems: Ensures that the item count is not less than 0 for a new cart.
//testCreateCartIntOutput: Checks that the item count is of type Integer.
//testCreateCartNotNullOutput: Verifies that the cart object is not null.

//Balance Tests:
//testGetBalanceEmptyCartInitialization: Tests that the balance of an empty cart is 0.0.
//testGetBalanceEmptyCartInitializationMoreThanZeroBalance: Checks that the balance is not greater than 0.0 for an empty cart.
//testGetBalanceEmptyCartInitializationLessThanZeroBalance: Confirms that the balance is not less than 0.0 for an empty cart.
//testGetbalanceDoubleOutput: Ensures the balance is of type Double.

//Cart Management Tests:
//testEmptyCart: Verifies that the cart has 0 items after calling empty().
//testEmptyCartNotNull: Confirms that the item count after emptying the cart is not null.
//testGetBalanceEmptyCartAfterEmpty: Tests that the balance is 0.0 after the cart is emptied.

//Product Addition Tests:
//testAddProduct: Verifies that adding a product increments the item count to 1 and checks that getPrice() was called.
//testAddProductNewBalance: Confirms that the new balance reflects the sum of the previous balance plus the new product's price.

//Product Deletion Tests:
//testDeleteProduct: Ensures that removing an existing product decreases the item count to 0.
//testDeleteProductVerifyPriceCalled: Verifies that the product's getPrice() method is called when a product is removed.
//testDeleteproductDoesNotExist: Checks that removing a non-existing product throws a ProductNotFoundException.
//testDeleteProductDoesNotExistVerifyPriceNotCalled: Ensures getPrice() is not called when trying to remove a non-existing product.
//testRemoveItemFromEmptyCart: Tests that trying to remove an item from an empty cart throws a ProductNotFoundException.
//testCartStateAfterFailedRemoval: Confirms the item count remains consistent after a failed removal of a non-existing product.
//testCartStateAfterFailedRemovalSVerifyPriceCalled: Ensures that getPrice() is still accessed for the added product after a failed removal attempt.
//testCartStateAfterFailedRemovalSVerifyPriceCalledShouldCallNullPointerException: Validates that an exception is caught during a removal attempt while ensuring getTitle() is called.

//Balance Verification Test:
//testVerifyProductPriceCalled: Verifies that getPrice() is called when checking the cart's balance.

//Parameterized Tests:
//testAddManyProducts: Tests adding multiple products and checks if the item count matches the expected number.
//testAddManyProductsTotalBalance: Verifies that the total balance correctly reflects the total price of all added products.

//Additional Tests:
//testProductEqualsSunny: Used to test the Products() equals method if running correctly
//testProductEqualsRainy: Used to test the Products() equals method if running correctly with different names
