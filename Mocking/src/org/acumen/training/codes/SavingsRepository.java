package org.acumen.training.codes;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SavingsRepository {
	private List<String> accountHolders;
	public LocalDate now = LocalDate.now();
	
	public String getMergedNames() {
		String res = accountHolders.stream()
				      .reduce((ms, s) -> String.join(" ", ms, s)).get();
		return res;
	}

	public void welcome(String message) {
		System.out.println(message);
	}
	
	public int getAccountSize() {
		return accountHolders.size();
	}

	public List<String> getAccountHolders() throws NullPointerException{
		if (accountHolders == null) {
			throw new NullPointerException("The record is empty");
		}
		return accountHolders.stream().map((n) -> n.toUpperCase()).toList();
	}

	public void setAccountHolders(List<String> accountHolders) {
		this.accountHolders = accountHolders;
	}
	
		
	public Double[] getAmounts() {
		return new Double[] {1000.00, 2000.00, 3000.00};
	}
	
	public LocalDate updateAccountDate(int days) {
		return this.now.plusDays(days);
	}
	
}
