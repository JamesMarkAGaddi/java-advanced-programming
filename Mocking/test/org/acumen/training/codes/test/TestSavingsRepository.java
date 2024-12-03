package org.acumen.training.codes.test;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
//import static org.mockito.Mockito.when; // General API, Test-driven Development
import static org.mockito.BDDMockito.given; // Mocking and testing APIs
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.atMost;
import static org.mockito.Mockito.atLeast;

import java.util.Arrays;
import java.util.List;

import org.acumen.training.codes.SavingsRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

// Step 1: Integration mocking framework to JUnit
@ExtendWith(MockitoExtension.class)
public class TestSavingsRepository {
	
	@Mock
	private SavingsRepository repo;
	

	@BeforeEach
	public void setup() {
		//repo = new SavingsRepository();
	}
	
	@AfterEach
	public void teardown() {
		//repo = null;
	}
	
	@Test
	public void testGetAccountHoldersNull() {
		//SavingsRepository mockrepo = mock(SavingsRepository.class);
		
		// Given
		given(repo.getAccountHolders()).willReturn(null);// proposal or assumption		
		
		// When
		List<String> res = repo.getAccountHolders();
		
		// Then
		assertNull(res);
		
		verify(repo, atMost(3)).getAccountHolders(); // default, exactly once
	
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void testAccountHoldersAnyInput() {
		List<String> names = Arrays.asList("Anna", "Lorna", "Fe");
		given(repo.getAccountHolders()).willReturn(null, names);
		
		List<String> res = repo.getAccountHolders();
		
		assertNull(res);
		System.out.println(res);
		
		res = repo.getAccountHolders();
		assertNotNull(res);
		System.out.println(res);
		
		verify(repo, times(2)).getAccountHolders();

	}
	
	@Test
	public void testGetAccountHoldersStart() {
		List<String> names = Arrays.asList("ANNA", "LORNA", "FE");
		given(repo.getAccountHolders()).willReturn(names); // Expectations
				
		repo.setAccountHolders(names);
		List<String> res = repo.getAccountHolders();
		
		assertIterableEquals(names, res);
	}
	
	
	
	
	

}
