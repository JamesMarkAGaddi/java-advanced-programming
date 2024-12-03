package org.acumen.training.codes.itemb.test;

import org.acumen.training.codes.itemb.ExerciseEleven;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestExerciseEleven {
	ExerciseEleven exer;
	String filename = "output.txt"; // Path to the file
	String message = "Hello, from thread!"; // Message to be written

	@BeforeEach
	public void setup() {
		exer = new ExerciseEleven();
		System.out.println("setup");
	}

	@AfterEach
	public void teardown() {
		exer = null;
		System.out.println("teardown");
	}

	@Test
	public void testExecute() {
		exer.execute(filename, message);
		
	}

}
