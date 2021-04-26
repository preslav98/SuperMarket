package com.endava.SuperMarket.utils;

import com.endava.SuperMarket.model.Item;

import java.util.List;

public class CalcPurchaseTotalPrice {
    public static Double calcTotalPrice(List<Item> items){
        Double total_price = 0.0;
        for(Item item:items){
            total_price += item.getPrice();
        }
        return total_price;
    }
}
