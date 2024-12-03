package org.acumen.training.codes.test;

import org.acumen.training.codes.Coin;
import org.acumen.training.codes.VendingMachine;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestVendingMachine {

	private VendingMachine vendingMachine;

	@BeforeEach
	public void setup() {
		vendingMachine = new VendingMachine();
	}

	@AfterEach
	public void teardown() {
		vendingMachine = null;
	}

	@Test
	public void testApp() {
		vendingMachine.insert(new Coin("Penny"));
		vendingMachine.insert(new Coin("Nickel"));
		vendingMachine.insert(new Coin("Dime"));
		vendingMachine.insert(new Coin("Quarter"));
		vendingMachine.insert(new Coin("HalfDollar"));

		try {
			vendingMachine.vend();
		} catch (Exception e) {
			e.printStackTrace();
		}

		vendingMachine.returnCoins();
		vendingMachine.insert(new Coin("InvalidCoin"));
	}
}



