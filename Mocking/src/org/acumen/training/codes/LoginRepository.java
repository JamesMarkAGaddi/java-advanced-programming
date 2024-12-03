package org.acumen.training.codes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class LoginRepository {
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
	
	
	public List<String> selectAllUsernames(){
		return null;
	}
	
	public boolean insertLogin(String username, String password) {
		return false;
	}

}
