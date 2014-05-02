package com.nuts.about.candies.model;

import java.math.BigDecimal;
import java.util.List;

public class Product {

	private String name;
	private BigDecimal price;
	private Size size;
	private Category category;
	private Type type;
	private int weight;
	private int shelfLife;
	private List<Ingredient> items;

	private enum Size {
		SMALL, MEDIUM, LARGE
	}

	private enum Category {
		ALL_ABOUT_NUTS, ALL_ABOUT_CANDIES, NUTS_AND_CANDIES
	}

	private enum Type {
		PREMIUM, REGULAR
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setSize(String size) {
		switch (size) {
		case "Small":
			this.size = Size.SMALL;
			price = new BigDecimal(50);
			this.weight = 50;
			break;
		case "Medium":
			this.size = Size.MEDIUM;
			price = new BigDecimal(100);
			this.weight = 100;
			break;
		case "Large":
			this.size = Size.LARGE;
			price = new BigDecimal(150);
			this.weight = 150;
			break;
		}
		if (type == Type.PREMIUM) {
			System.out.println("Premium!!!");
			price = price.add(new BigDecimal(20));
		}
	}

	public void setType(String type) {
		switch (type) {
		case "Premium":
			this.type = Type.PREMIUM;
			break;
		case "Regular":
			this.type = Type.REGULAR;
			break;

		}
	}

	public List<Ingredient> getItems() {
		return items;
	}

	public void setItems(List<Ingredient> items) {
		this.items = items;
		int nutsCounter = 0;
		int candiesCounter = 0;
		for (Ingredient i : items) {
			System.out.println("Inside items: Name : " + i.getName() + " "
					+ "Category : " + i.getCategory());
			if (i.getCategory().equals("Nuts"))
				nutsCounter++;
			else
				candiesCounter++;
		}
		if (nutsCounter == items.size()) {
			this.category = Category.ALL_ABOUT_NUTS;
			this.shelfLife = 30;
			return;
		} else if (candiesCounter == items.size()) {
			this.category = Category.ALL_ABOUT_CANDIES;
			this.shelfLife = 90;
			return;
		} else {
			this.category = Category.NUTS_AND_CANDIES;
			this.shelfLife = 30;
			return;
		}
	}

	public String getSize() {
		switch (size) {
		case SMALL:
			return "Small";
		case MEDIUM:
			return "Medium";
		case LARGE:
			return "Large";
		default:
			return "";
		}
	}

	public String getCategory() {
		switch (category) {
		case ALL_ABOUT_CANDIES:
			return "All About Candies";
		case ALL_ABOUT_NUTS:
			return "All About Nuts";
		case NUTS_AND_CANDIES:
			return "Nuts And Candies";
		default:
			return "";
		}
	}

	public String getType() {
		switch (type) {
		case PREMIUM:
			return "Premium";
		case REGULAR:
			return "Regular";
		default:
			return "";
		}
	}

	public int getWeight() {
		return weight;
	}

	public int getShelfLife() {
		return shelfLife;
	}

	public String getName() {
		return name;
	}

	public BigDecimal getPrice() {
		return price;
	}

}
