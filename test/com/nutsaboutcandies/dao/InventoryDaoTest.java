package com.nutsaboutcandies.dao;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.nutsaboutcandies.model.Ingredient;
import com.nutsaboutcandies.model.Product;

public class InventoryDaoTest {

	private InventoryDao inventoryDao = new InventoryDao();
	private Product product = new Product();
	private List<Ingredient> items = new ArrayList<Ingredient>();
	private Ingredient item = new Ingredient();
	
	@Test
	public void addProductTest() {
		item.setName("Weeee");
		item.setCategory("Nuts");
		items.add(item);
		
		item = new Ingredient();
		item.setName("Weeee");
		item.setCategory("Nuts");
		items.add(item);
		
		product.setType("Regular");
		product.setName("Kings");
		product.setSize("Large");
		product.setStock(20);
		product.setItems(items);
		
		assertTrue(inventoryDao.addProduct(product));
//		assertFalse(inventoryDao.addProduct(new Product()));
	}
//	
//	@Test
//	public void removeProductTest() {
//		assertTrue(inventoryDao.removeProduct(1));
//	}
	
	@Test
	public void updateProductTest() {
		item.setName("Weeqee");
		item.setCategory("Nuts");
		items.add(item);
		
		item = new Ingredient();
		item.setName("Weeqee");
		item.setCategory("Candies");
		items.add(item);
		
		product.setType("Premium");
		product.setName("Kingss");
		product.setSize("Small");
		product.setItems(items);
		assertTrue(inventoryDao.updateProduct(product, 11));
	}
	
	@Test
	public void retrieveProductsTest() {
		assertNotNull(inventoryDao.retrieveProducts());
		assertEquals(26, inventoryDao.retrieveProducts().size());
	}
	
	@Test
	public void updateStockTest() {
		assertTrue(inventoryDao.updateStock(3, 20));
	}
}
