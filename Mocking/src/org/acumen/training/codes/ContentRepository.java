package org.acumen.training.codes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ContentRepository {
    private Connection conn;
	
	public boolean openConnect(String url, String username, String password) {
		try {
			conn = DriverManager.getConnection(url, username, password);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean insertContent(String content) {
		return false;
	}
	
	

}
