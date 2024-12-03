package org.acumen.training.codes.itema;

import java.util.ArrayList;
import java.util.Iterator;

@SuppressWarnings("rawtypes")
public class ShoppingCart {
	private ArrayList items;

	public ShoppingCart() {
		items = new ArrayList();
	}

	public double getBalance() {
		double balance = 0.00;
		for (Iterator i = items.iterator(); i.hasNext();) {
			Product item = (Product) i.next();
			balance += item.getPrice();
		}
		return balance;
	}

	@SuppressWarnings("unchecked")
	public void addItem(Product item) {
		items.add(item);
	}

	public void removeItem(Product item) throws ProductNotFoundException {
		if (!items.remove(item)) {
			throw new ProductNotFoundException();
		}

	}

	public int getItemCount() {
		return items.size();
	}

	public void empty() {
		items.clear();
	}
}
