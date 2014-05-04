package com.nutsaboutcandies.user;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.nutsaboutcandies.model.Product;

public class Cart {
	private User owner;
	private Timestamp purchaseDate;
	private List<Product> items = new ArrayList<Product>();

	public User getOwner() {
		return owner;
	}

	public Date getPurchaseDate() {
		return purchaseDate;
	}

	public List<Product> getProducts() {
		return items;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}

	public void setPurchaseDate(Timestamp purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public void setProducts(List<Product> products) {
		this.items = products;
	}
	
	public int getNumberOfItems() {
		return items.size();
	}

}
