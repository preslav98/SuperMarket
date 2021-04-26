package com.endava.SuperMarket.dto.response;

import com.endava.SuperMarket.model.Item;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class SuperMarketResponseDto {

    private String marketName;

    private String marketAddress;

    private String phoneNumber;

    private String workHours;

    private List<ItemResponseDto> items;
}
