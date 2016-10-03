package com.xyz.model;

public class BilledItem {
	
	public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
	}
	public Double getSaleTax() {
		return saleTax;
	}
	public void setSaleTax(Double saleTax) {
		this.saleTax = saleTax;
	}
	public Double getRate() {
		return rate;
	}
	public void setRate(Double rate) {
		this.rate = rate;
	}
	Item item;
	Double saleTax;
	Double rate;
	public BilledItem(Item item, Double saleTax, Double rate) {
		super();
		this.item = item;
		this.saleTax = saleTax;
		this.rate = rate;
	}
	
	public String toString(){
		
		return "Name : " + item.getName() + " Sales Tax : " + saleTax + " Cost : " + rate;
		
	}
	
	
	
	
	

}
