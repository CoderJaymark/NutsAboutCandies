package com.nutsaboutcandies.user;

import java.util.Date;
import java.util.List;

import com.nutsaboutcandies.model.Product;

public class Cart {
	private User owner;
	private Date purchaseDate;
	private List<Product> items;

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

	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public void setProducts(List<Product> products) {
		this.items = products;
	}
	
	public int getNumberOfItems() {
		return items.size();
	}

}
