package org.acumen.training.codes;

public class LoginService {
	
	private LoginRepository repo = new LoginRepository();
	
	public LoginService(LoginRepository repo) {
		this.repo = repo;
	}
	
	public int getTotalUserName() {
		repo.selectAllUsernames();
		return repo.selectAllUsernames().size();
	}
	
	public int setLoginDetails(String username, String password) {
		boolean res = repo.insertLogin(username, password);
		if (res) {
			System.out.println(String.format("%s %s", username, password));
			return 1;
		}
		return 0;
	}

}
