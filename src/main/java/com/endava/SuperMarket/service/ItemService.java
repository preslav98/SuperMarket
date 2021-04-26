package com.endava.SuperMarket.service;

import com.endava.SuperMarket.model.Item;

import java.util.List;

public interface ItemService {

    Item save(Item item);

    List<Item> findItemsById(List<String> ids);
}
