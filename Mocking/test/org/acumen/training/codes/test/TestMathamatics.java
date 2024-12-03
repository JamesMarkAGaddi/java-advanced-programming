package org.acumen.training.codes.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.BDDMockito.given;

import org.acumen.training.codes.Mathematics;
import org.acumen.training.codes.NegativeOperandException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class TestMathamatics {
	
	@Mock
	private Mathematics math;
	
	@Test
	public void testAddPositiveOperandsRainy() {
		int expectedValue = 100;
		try {
			given(math.add(anyInt(), anyInt())).willReturn(expectedValue);
			 int actualValue = math.add(50, 20);
			assertEquals(expectedValue, actualValue);
		} catch (NegativeOperandException e) {
			e.printStackTrace();
		}
		
       
	}
	
	
	@Test
	public void testAddNegativeOperands() {
		int x = -10;
		int y = -20;
		try {
			given(math.add(x, y)).willThrow(NegativeOperandException.class);
			assertThrows(NegativeOperandException.class, () -> {
				 int actualValue = math.add(x, y);
				 assertEquals(100, actualValue);
			});
		} catch (NegativeOperandException e) {
			e.printStackTrace();
		}
		
       		
		
	}
}





