package org.acumen.training.codes.test;

import org.acumen.training.codes.JacksonSerialization;
import org.junit.jupiter.api.Test;

public class TestJacksonSerialization {

	@Test
	public void testCreateXML() {
		JacksonSerialization jacksonSerialization = new JacksonSerialization();
		jacksonSerialization.createXML();
	}
}
