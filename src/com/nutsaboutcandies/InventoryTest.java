package com.nutsaboutcandies;

import java.util.List;

import com.nutsaboutcandies.dao.InventoryDao;
import com.nutsaboutcandies.model.Ingredient;
import com.nutsaboutcandies.model.Product;

public class InventoryTest {
	public static void main(String[] args) {
		InventoryDao inv = new InventoryDao();
		List<Product> products = inv.retrieveProducts(true);
		System.out.println("Name\t\tType\tCategory\tPrice\tSize\tShelf\tWeight\tItems");
		for(Product p: products) {
			System.out.print(p.getName()+ "\t" + p.getType() + "\t" + p.getCategory() + "\t" + p.getPrice());
			System.out.print("\t" + p.getSize() + "\t" + p.getShelfLife() + "\t" + p.getWeight());
			for(Ingredient i: p.getItems()) {
				System.out.print(i.getName() + "(" +i.getCategory() + "), ");
			}
			System.out.println();
		}
	}
}
