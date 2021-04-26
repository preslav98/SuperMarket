package com.endava.SuperMarket.repository;

import com.endava.SuperMarket.model.SuperMarket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SuperMarketRepository extends JpaRepository<SuperMarket, String> {
}
