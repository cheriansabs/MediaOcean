package com.xyz.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.xyz.billing.Biller;
import com.xyz.model.Bill;
import com.xyz.model.Item;

@RestController
public class BillingController {


    @RequestMapping(value="/generateBill",consumes="application/json",
            produces="application/json",
            method=RequestMethod.POST)
    public Bill getBill(@RequestBody List<Item> items) {
       Bill bill= new Biller().getBill(items);
       System.out.println(bill);
       return bill;
    }
}
