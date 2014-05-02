package com.nuts.about.candies;

import com.nuts.about.candies.dao.InventoryDao;
import com.nuts.about.candies.model.Product;

public class Tester {
	public static void main(String[] args) {
		new InventoryDao().addProduct(new Product());
	}

}
