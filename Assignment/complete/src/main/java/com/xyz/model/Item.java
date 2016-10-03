package com.xyz.model;

import com.xyz.billing.Category;

public class Item {

	
	public Item() {
		super();
	}
	private String name;
	private Double rate;
	private Category category;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getRate() {
		return rate;
	}
	public void setRate(Double rate) {
		this.rate = rate;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public Item(String name, Double rate, Category category) {
		super();
		this.name = name;
		this.rate = rate;
		this.category = category;
	}
	
}
