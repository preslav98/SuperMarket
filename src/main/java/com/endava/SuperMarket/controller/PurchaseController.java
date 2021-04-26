package com.endava.SuperMarket.controller;


import com.endava.SuperMarket.dto.request.PurchaseRequestDto;
import com.endava.SuperMarket.dto.response.PurchaseInfoResponseDto;
import com.endava.SuperMarket.exception.SuperMarketNotFoundException;
import com.endava.SuperMarket.model.Item;
import com.endava.SuperMarket.model.Purchase;
import com.endava.SuperMarket.model.enums.PaymentType;
import com.endava.SuperMarket.service.ItemService;
import com.endava.SuperMarket.service.PurchaseService;
import com.endava.SuperMarket.service.SuperMarketService;
import com.endava.SuperMarket.utils.CalcPurchaseTotalPrice;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import static java.lang.String.format;

@RestController
@RequestMapping("/purchases")
public class PurchaseController {

    private final PurchaseService purchaseService;
    private final SuperMarketService marketService;
    private final ItemService itemService;
    private final ModelMapper modelMapper;

    @Autowired
    public PurchaseController(PurchaseService purchaseService, SuperMarketService marketService, ItemService itemService, ModelMapper modelMapper) {
        this.purchaseService = purchaseService;
        this.marketService = marketService;
        this.itemService = itemService;
        this.modelMapper = modelMapper;
    }

    @PostMapping
    public ResponseEntity<PurchaseInfoResponseDto> buyItemsFromSuperMarket(
           @Valid @RequestBody PurchaseRequestDto purchaseDto){
        String superMarketId = purchaseDto.getSuperMarketId();
        PaymentType type = purchaseDto.getPaymentType();
        marketService.findById(purchaseDto.getSuperMarketId()).orElseThrow(()->
                new SuperMarketNotFoundException(format("No supermarket with id of %s", superMarketId)));
        List<Item> items = itemService.findItemsById(purchaseDto.getItemIds());
        Double total_price = CalcPurchaseTotalPrice.calcTotalPrice(items);
        if(type == PaymentType.CASH) {
            Double change = purchaseDto.getCashAmount() - total_price;
            Purchase purchase = Purchase.builder().superMarketId(superMarketId).items(items)
                    .totalCost(total_price).change(change).paymentType(type).dateOfPurchase(LocalDate.now()).build();
            return new ResponseEntity<>(modelMapper.map(purchaseService.save(purchase), PurchaseInfoResponseDto.class),
                    HttpStatus.CREATED);
        }
        Purchase purchase = Purchase.builder().superMarketId(superMarketId).items(items)
                .totalCost(total_price).paymentType(type).dateOfPurchase(LocalDate.now()).build();
        return new ResponseEntity<>(modelMapper.map(purchaseService.save(purchase), PurchaseInfoResponseDto.class),
                HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<PurchaseInfoResponseDto>> getAllPurchases(){
        List<Purchase> purchases = purchaseService.findAll();
        List<PurchaseInfoResponseDto> dto = purchases.stream()
                .map(p -> modelMapper.map(p, PurchaseInfoResponseDto.class))
                .collect(Collectors.toList());
        return new ResponseEntity<List<PurchaseInfoResponseDto>>( dto,
                HttpStatus.OK);
    }

}
