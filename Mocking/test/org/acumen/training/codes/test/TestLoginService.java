package org.acumen.training.codes.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;
import static org.mockito.ArgumentMatchers.anyString;

import java.util.Arrays;
import java.util.List;

import org.acumen.training.codes.LoginRepository;
import org.acumen.training.codes.LoginService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class TestLoginService {
	
	@Mock
	private LoginRepository repo;
	
	@InjectMocks
	private LoginService login = new LoginService(repo);
	
	@Test
	public void testGetCountUsernames() {
		List<String> usernames = Arrays.asList("root", "postgresql");
		given(repo.selectAllUsernames()).willReturn(usernames);
	
		int count = login.getTotalUserName();
		assertEquals(usernames.size(), count);
		
		verify(repo, times(2)).selectAllUsernames();
	}
	
	@Test
	public void testSetLoginDetails() {
		given(repo.insertLogin(anyString(), anyString())).willReturn(true);
		
		int res = login.setLoginDetails("root", "root");
		
		assertEquals(1, res);	
		
		verify(repo).insertLogin(anyString(), anyString());
	}

}
