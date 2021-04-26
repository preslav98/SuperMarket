package com.endava.SuperMarket.service;

import com.endava.SuperMarket.model.Purchase;

import java.util.List;

public interface PurchaseService {

    Purchase save(Purchase purchase);

    List<Purchase> findAll();
}
