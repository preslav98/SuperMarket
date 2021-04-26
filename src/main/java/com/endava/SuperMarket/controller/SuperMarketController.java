package com.endava.SuperMarket.controller;

import com.endava.SuperMarket.dto.request.AddItemsDto;
import com.endava.SuperMarket.dto.SuperMarketInfoDto;
import com.endava.SuperMarket.dto.response.SuperMarketResponseDto;
import com.endava.SuperMarket.exception.SuperMarketNotFoundException;
import com.endava.SuperMarket.model.Item;
import com.endava.SuperMarket.model.SuperMarket;
import com.endava.SuperMarket.service.ItemService;
import com.endava.SuperMarket.service.SuperMarketService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static java.lang.String.format;

@RestController
@RequestMapping(value = "/supermarkets")
public class SuperMarketController {

    private final SuperMarketService marketService;
    private final ModelMapper modelMapper;
    private final ItemService itemService;

    @Autowired
    public SuperMarketController(SuperMarketService marketService, ModelMapper modelMapper, ItemService itemService) {
        this.marketService = marketService;
        this.modelMapper = modelMapper;
        this.itemService = itemService;
    }

    @PostMapping
    public ResponseEntity<SuperMarketInfoDto> createSuperMarket(@Valid @RequestBody SuperMarketInfoDto marketInfoDto) {
        SuperMarket marketToBeCreated = modelMapper.map(marketInfoDto, SuperMarket.class);
        return new ResponseEntity<>(modelMapper.map(marketService.save(marketToBeCreated), SuperMarketInfoDto.class),
                HttpStatus.CREATED);
    }

    @PatchMapping
    public ResponseEntity<AddItemsDto> addItemsToSuperMarket(@Valid @RequestBody AddItemsDto addItemsDto) {
        String marketId = addItemsDto.getMarketId();
        SuperMarket market = marketService.findById(marketId).orElseThrow(
                () -> new SuperMarketNotFoundException(format("No supermarket with id of %s", marketId)));
        List<Item> items = itemService.findItemsById(addItemsDto.getItemIds());
        market.setItems(items);
        marketService.save(market);
        return new ResponseEntity<>(addItemsDto, HttpStatus.OK);
    }

    @GetMapping(value = "/{superMarketId}")
    public ResponseEntity<SuperMarketResponseDto> getSuperMarketById(@PathVariable String superMarketId){
        SuperMarket market = marketService.findById(superMarketId).orElseThrow(
                () -> new SuperMarketNotFoundException(format("No supermarket with id of %s", superMarketId)));
        return new ResponseEntity<>(modelMapper.map(market, SuperMarketResponseDto.class),
        HttpStatus.FOUND);
    }

}
