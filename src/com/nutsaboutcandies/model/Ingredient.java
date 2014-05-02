package com.nutsaboutcandies.model;

public class Ingredient {

	private String name;
	private Category category;

	private enum Category {
		NUTS, CANDIES
	}

	public String getName() {
		return name;
	}

	public String getCategory() {
		switch (category) {
		case CANDIES:
			return "Candies";
		case NUTS:
			return "Nuts";
		default:
			return "";
		}
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setCategory(String category) {
		switch(category) {
		case "Nuts" : this.category = Category.NUTS;break;
		case "Candies" : this.category = Category.CANDIES;break;
		}
	}

}
