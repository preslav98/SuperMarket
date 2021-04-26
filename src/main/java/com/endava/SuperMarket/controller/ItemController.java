package com.endava.SuperMarket.controller;

import com.endava.SuperMarket.dto.ItemInfoDto;
import com.endava.SuperMarket.model.Item;
import com.endava.SuperMarket.service.ItemService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/items")
public class ItemController {

    private final ItemService itemService;
    private final ModelMapper modelMapper;

    @Autowired
    public ItemController(ItemService itemService, ModelMapper modelMapper) {
        this.itemService = itemService;
        this.modelMapper = modelMapper;
    }

    @PostMapping
    public ResponseEntity<ItemInfoDto> createItem(@Valid @RequestBody ItemInfoDto itemInfoDto) {
        Item itemToBeCreated = modelMapper.map(itemInfoDto, Item.class);
        return new ResponseEntity<>(modelMapper.map(itemService.save(itemToBeCreated), ItemInfoDto.class), HttpStatus.CREATED);
    }

}
