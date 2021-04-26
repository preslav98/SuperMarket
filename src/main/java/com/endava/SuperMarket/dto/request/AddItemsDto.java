package com.endava.SuperMarket.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class AddItemsDto {

    @NotNull(message = "MarketId cannot be null.")
    private String marketId;

    @NotEmpty(message = "ItemIds cannot be empty.")
    private List<@NotNull(message = "itemIds values cannot be null.") String> itemIds;
}
