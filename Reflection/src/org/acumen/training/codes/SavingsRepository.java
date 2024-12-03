package org.acumen.training.codes;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class SavingsRepository {

	@Fetched(kind = "list", data = { 1, 2, 4 })
	private List<String> accountHolders = new ArrayList<String>();

	@Fetched(kind = "object", data = { 10, 11 })
	public LocalDate now = LocalDate.now();

	@Test(disabled = false)
	public String getMergedNames() {
		String res = accountHolders.stream().reduce((ms, s) -> String.join(" ", ms, s)).get();
		return res;
	}

	@Test(disabled = true)
	private void welcome(String message) {
		System.out.println("Welcome customers! %s".formatted(message));
	}
}
