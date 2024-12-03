package org.acumen.training.codes.test;

import org.acumen.training.codes.SAXReader;
import org.junit.jupiter.api.Test;

public class TestSAXReader {

	@Test
	public void testSAXReader() {
		SAXReader saxReader = new SAXReader();
		saxReader.readXML("./src/files/employees.xml");
	}
}
