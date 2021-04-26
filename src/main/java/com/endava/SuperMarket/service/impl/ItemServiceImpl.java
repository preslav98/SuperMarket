package com.endava.SuperMarket.service.impl;

import com.endava.SuperMarket.model.Item;
import com.endava.SuperMarket.repository.ItemRepository;
import com.endava.SuperMarket.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {

    private final ItemRepository itemRepository;

    @Autowired
    public ItemServiceImpl(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Override
    public Item save(Item item) {
        return itemRepository.save(item);
    }

    @Override
    public List<Item> findItemsById(List<String> ids) {
        return itemRepository.findAllById(ids);
    }
}
