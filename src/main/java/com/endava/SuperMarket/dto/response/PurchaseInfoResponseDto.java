package com.endava.SuperMarket.dto.response;

import com.endava.SuperMarket.model.enums.PaymentType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class PurchaseInfoResponseDto {

    private String superMarketId;

    private List<ItemResponseDto> items;

    private LocalDate dateOfPurchase;

    private PaymentType paymentType;

    private Double totalCost;

    private Double change;


}
