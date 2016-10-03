package com.xyz.billing;

import java.util.List;

import com.xyz.model.Bill;
import com.xyz.model.BilledItem;
import com.xyz.model.Item;

public class Biller {

	public Bill getBill(List<Item> items) {
		// TODO Auto-generated method stub
		
		Bill bill = new Bill();
		
		items.forEach(item->
		{
			
			BilledItem billedItem = getBilledItem(item);
			bill.addToBilledItems(billedItem);
			bill.setTotalSalesTax(bill.getTotalSalesTax()+billedItem.getSaleTax());
			bill.setTotalCost(bill.getTotalCost() + billedItem.getRate());
			
			
			
		});
		
		return bill;
	
	}

	private BilledItem getBilledItem(Item item) {
		
		Double salesTax = item.getCategory().equals(Category.A)?((10*item.getRate())/100):item.getCategory().equals(Category.B)?((20*item.getRate())/100):0;
		Double rate=item.getRate()+salesTax;
		BilledItem billedItem = new BilledItem(item, salesTax, rate);
		return billedItem;
		
	}

}
