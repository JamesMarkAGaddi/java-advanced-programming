package org.acumen.training.codes;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileRetrieval {
	
	
	public String getContent(String filename) {
		
		try (FileInputStream fis = new FileInputStream(filename);){
			return "";
		} catch(FileNotFoundException ex) {
			ex.printStackTrace();
		} catch(IOException ex) {
			ex.printStackTrace();
		}
		return null;
	}

}
