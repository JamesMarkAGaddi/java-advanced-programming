package org.acumen.training.codes;

public class ContentService {
	private ContentRepository repo = new ContentRepository();
	private FileRetrieval ft = new FileRetrieval();
	
	public ContentService(ContentRepository repo, FileRetrieval ft) {
		this.repo = repo;
		this.ft = ft;
	}
	
	public String manageContent(String filename) {
		String content = ft.getContent(filename);
		boolean isInserted = repo.insertContent(content);
		System.out.println(content);
		System.out.println(isInserted);
		return content;
	}

}
