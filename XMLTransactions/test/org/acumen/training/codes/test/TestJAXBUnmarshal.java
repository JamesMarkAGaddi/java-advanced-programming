package org.acumen.training.codes.test;

import org.acumen.training.codes.JAXBUnmarshal;
import org.junit.jupiter.api.Test;

public class TestJAXBUnmarshal {

	@Test
	public void readXML() {
		JAXBUnmarshal unmarshal = new JAXBUnmarshal();
		unmarshal.readXML();
	}
}
