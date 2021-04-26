package com.endava.SuperMarket.service;

import com.endava.SuperMarket.model.SuperMarket;

import java.util.Optional;

public interface SuperMarketService {
    SuperMarket save(SuperMarket market);

    Optional<SuperMarket> findById(String id);
}
