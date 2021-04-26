package com.endava.SuperMarket.dto.request;

import com.endava.SuperMarket.model.enums.PaymentType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class PurchaseRequestDto {

    @NotBlank(message = "Field supermarket_id cannot be blank.")
    private String superMarketId;

    @Enumerated(EnumType.STRING)
    @NotNull(message = "Field payment_type cannot be null.")
    private PaymentType paymentType;

    private Double cashAmount;

    @NotEmpty(message = "ItemIds cannot be empty.")
    private List<String> itemIds;
}
