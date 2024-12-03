package org.acumen.training.codes.test;

import org.acumen.training.codes.ContentRepository;
import org.acumen.training.codes.ContentService;
import org.acumen.training.codes.FileRetrieval;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.Assert.assertTrue;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class TestContentService {
	
	@Mock
	private FileRetrieval ft;
	
	@Mock
	private ContentRepository repo;
	
	@InjectMocks
	private ContentService service = new ContentService(repo, ft);
	
	@Test
	public void testManageContent() {
		String filename = "./src/files/content.txt";
		String content = "The fox jumps over the window.";
		given(ft.getContent(filename))
		      .willReturn(content);
		given(repo.insertContent("The fox jumps over the window.")).willReturn(true);
		
		String res = service.manageContent(filename);
		
		assertTrue(content.equals(res));
		
		verify(ft).getContent(filename);
		verify(repo).insertContent(content);
	}

}
