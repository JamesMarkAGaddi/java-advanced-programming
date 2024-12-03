package org.acumen.training.codes.test;

import org.acumen.training.codes.JacksonDeserialization;
import org.junit.jupiter.api.Test;

public class TestJacksonDeserialization {

	@Test
	public void testCreateXML() {
		JacksonDeserialization jacksondeserialization = new JacksonDeserialization();
		jacksondeserialization.readXML();
	}
}
