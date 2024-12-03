package org.acumen.training.codes.test;

import org.acumen.training.codes.JAXBMarshal;
import org.junit.jupiter.api.Test;

public class TestJAXBMarshal {

	@Test
	public void testCreateXML() {
		
		JAXBMarshal marshal = new JAXBMarshal();
		marshal.createXML();
	}
}
