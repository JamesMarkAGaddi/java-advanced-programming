package org.acumen.training.codes.test;

import static org.mockito.Mockito.lenient;

import org.acumen.training.codes.HelloWorld;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class TestHelloWorld {
	@Mock
	private HelloWorld hw;
	
	@Test
	public void testGetMessage() {
		lenient().doNothing().when(hw).getMessage(); // Verification
		
	}

}
