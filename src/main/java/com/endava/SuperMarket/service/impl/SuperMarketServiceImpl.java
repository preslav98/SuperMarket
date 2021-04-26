package com.endava.SuperMarket.service.impl;

import com.endava.SuperMarket.model.SuperMarket;
import com.endava.SuperMarket.repository.SuperMarketRepository;
import com.endava.SuperMarket.service.SuperMarketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SuperMarketServiceImpl implements SuperMarketService {

    private final SuperMarketRepository superMarketRepository;

    @Autowired
    public SuperMarketServiceImpl(SuperMarketRepository superMarketRepository) {
        this.superMarketRepository = superMarketRepository;
    }

    @Override
    public SuperMarket save(SuperMarket market) {
        return superMarketRepository.save(market);
    }

    @Override
    public Optional<SuperMarket> findById(String id) {
        return superMarketRepository.findById(id);
    }
}
