package org.acumen.training.codes.test;

import org.acumen.training.codes.JacksonJSONSerial;
import org.junit.jupiter.api.Test;

public class TestJacksonJSONSerial {

	@Test
	public void testCreateJSON() {
		JacksonJSONSerial jsonSerial = new JacksonJSONSerial();
		jsonSerial.createJSON();
	}
}
