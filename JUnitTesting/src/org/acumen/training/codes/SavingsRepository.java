package org.acumen.training.codes;

import java.time.LocalDate;
import java.util.List;

public class SavingsRepository {

	private List<String> accountHolders;

	public LocalDate now = LocalDate.now();

	public String getMergedNames() {
		String res = accountHolders.stream().reduce((ms, s) -> String.join(" ", ms, s)).get();
		return res;
	}

	public void welcome(String message) {
		System.out.println("Welcome customers! %s".formatted(message));
	}

	public int getAccountSize() { // hindi ito papasok, if default,sa JUnit na iba ang packge name kasi nga
									// default
		return accountHolders.size();
	}

	public List<String> getAccountHolders() throws NullPointerException {
	
		if (accountHolders == null) {
			throw new NullPointerException("The record is empty.");
		}
		return accountHolders.stream().map((n) -> n.toUpperCase()).toList();
	}

	public void setAccountHolders(List<String> accountHolders) {
		this.accountHolders = accountHolders;
	}

	public Double[] getAmounts() {
		return new Double[] { 1000.0, 2000.0, 3000.0 };
	}

	public LocalDate updateAccountDate(int days) {
		return this.now.plusDays(days);
	}
}
