package com.endava.SuperMarket.dto.response;

import com.endava.SuperMarket.model.enums.ItemType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ItemResponseDto {

    private String id;

    private String itemName;

    private Double price;

    private ItemType itemType;
}
