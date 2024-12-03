package org.acumen.training.codes.test;

import org.acumen.training.codes.TrapArray;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestTrapArray {

	private TrapArray trap;

	@BeforeEach
	public void setup() {
		trap = new TrapArray();
	}

	@AfterEach
	public void teardown() {
		trap = null;
	}

	@Test
	public void testApp() {
		trap.arrayTransact();		
	}
}