package com.nutsaboutcandies.user;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.nutsaboutcandies.model.Product;

public class Cart {
	private User owner;
	private Timestamp purchaseDate;
	private List<Product> products = new ArrayList<Product>();
	private int numberOfItems;
	private double total;
	private double subtotal;
	private double deliveryCharge = 50.0;
	private double discount;
	private int[] quantities;

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
	
	public double getTotal() {
	 return 0;
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
	
	public double getSubtotal() {
		double subtotal = 0;
		for(Product p : getProducts()) {
			subtotal += p.getStock() * p.getPrice().intValue();
		}
		this.subtotal = subtotal;
		return subtotal;
	}
	
	public void updateStock(int[] updatedStocks) {
		int counter = 0;
		for(int i = 0; i < updatedStocks.length; i++) {
			products.get(i).setStock(updatedStocks[counter++]);
		}
		
	}
	
	public int[] getQuantities() {
		int[] quantities = new int[getProducts().size()];
		for(int i=0;i<quantities.length;i++) {
			quantities[i] = getProducts().get(i).getStock();
		}
		return quantities;
	}
	
	public double getDiscount() {
		System.out.println(subtotal);
		if(subtotal>=2000) {
			discount = subtotal * 0.05;
			System.out.println(discount);
			subtotal -= discount;
		}
		return discount;
	}
	
	public double getDeliveryCharge() {
		int totalWeight = 0;
		for(Product p : products ) {
			totalWeight += p.getWeight();
		}
		
		
		if(totalWeight > 500) {
			int excessWeight = totalWeight - 500;
			do{
				deliveryCharge += 10;
				excessWeight-=100;
			} while(excessWeight >= 0);
		}
		return deliveryCharge;
	}
	

}
