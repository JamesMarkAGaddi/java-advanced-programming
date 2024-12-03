package org.acumen.training.codes.test;

import org.acumen.training.codes.DOMParsing;
import org.junit.jupiter.api.Test;

public class TestDOMParsing {

	@Test
	public void testCreateXML() {
		DOMParsing domParsing = new DOMParsing();
		domParsing.readXML();
	}
}
