package org.acumen.training.codes.test;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.acumen.training.codes.SimpleApp;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestSimpleApp {

	private static final Logger LOGGER = LogManager.getLogger("TestSimpleApp");
	private SimpleApp app;

	@BeforeEach
	public void setup() {
		LOGGER.info("Start of testApp()");
		app = new SimpleApp();
	}

	@AfterEach
	public void teardown() {
		LOGGER.info("End of testApp()");
		app = null;
	}

	@Test
	public void testApp() {
		boolean res = app.returnOne() == 1;
		assertTrue(res, "app didn't return 1");
	}
}