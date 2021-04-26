package com.endava.SuperMarket.service.impl;

import com.endava.SuperMarket.model.Purchase;
import com.endava.SuperMarket.repository.PurchaseRepository;
import com.endava.SuperMarket.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PurchaseServiceImpl implements PurchaseService {

    private final PurchaseRepository purchaseRepository;

    @Autowired
    public PurchaseServiceImpl(PurchaseRepository purchaseRepository) {
        this.purchaseRepository = purchaseRepository;
    }

    @Override
    public Purchase save(Purchase purchase) {
        return purchaseRepository.save(purchase);
    }

    @Override
    public List<Purchase> findAll() {
        return purchaseRepository.findAll();
    }
}
