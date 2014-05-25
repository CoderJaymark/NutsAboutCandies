package com.nutsaboutcandies.user;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import com.nutsaboutcandies.model.Product;

public class Cart {
	private User owner;
	private Timestamp purchaseDate;
	private List<Product> products = new ArrayList<Product>();
	private int numberOfItems;
	private int total;

	public User getOwner() {
		return owner;
	}

	public Date getPurchaseDate() {
		return purchaseDate;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}

	public void setPurchaseDate(Timestamp purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}
	
	public int getNumberOfItems() {
		numberOfItems = 0;
		for(Product p: getProducts()) {
			numberOfItems += p.getStock();
		}
		return numberOfItems;
	}
	
	public int getTotal() {
		int total = 0;
		for(Product p : getProducts()) {
			total += p.getStock() * p.getPrice().intValue();
		}
		
		return total;
	}
	
	public void addProduct(Product p) {
		for(Product p2 : products) {
			if(p2.getId() == p.getId()) {
				p2.setStock(p.getStock() + p2.getStock());
				return;
			}
		}
		products.add(0, p);
	}
	
	public void removeProduct(int id) {
		products.remove(id);
	}
	
	public Product getProduct(int id) {
		return products.get(id);
	}

}
