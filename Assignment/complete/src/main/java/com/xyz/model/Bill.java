package com.xyz.model;

import java.util.ArrayList;
import java.util.List;

public class Bill {

	private List<BilledItem> lstBilledItems = new ArrayList<>();
	private Double totalSalesTax=0D;
	private Double totalCost=0D;

	public Bill() {
		super();
	}
	public List<BilledItem> getLstBilledItems() {
		return lstBilledItems;
	}
	public void setLstBilledItems(List<BilledItem> lstBilledItems) {
		this.lstBilledItems = lstBilledItems;
	}
	public Double getTotalSalesTax() {
		return totalSalesTax;
	}
	public void setTotalSalesTax(Double totalSalesTax) {
		this.totalSalesTax = totalSalesTax;
	}
	public Double getTotalCost() {
		return totalCost;
	}
	public void setTotalCost(Double totalCost) {
		this.totalCost = totalCost;
	}
	
	public void addToBilledItems(BilledItem item){
		lstBilledItems.add(item);
	}
	
	public String toString(){
		
		StringBuffer sb = new StringBuffer();
		
		lstBilledItems.forEach(
	    		   billedItem->{sb.append(billedItem.toString());sb.append(System.lineSeparator());}
	    		   );
		sb.append("Total Salex Tax " + getTotalSalesTax());
		sb.append(System.lineSeparator());
		sb.append("Total Cost " + getTotalCost());
		
		return sb.toString();
	}
	
	
		
	
}
