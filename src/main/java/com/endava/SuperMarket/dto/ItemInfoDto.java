package com.endava.SuperMarket.dto;

import com.endava.SuperMarket.model.enums.ItemType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
public class ItemInfoDto {

    @NotBlank(message = "Field name cannot be blank.")
    private String itemName;

    @NotNull(message = "Field price cannot be null.")
    private Double price;

    @Enumerated(EnumType.STRING)
    @NotNull(message = "Field item type cannot be null.")
    private ItemType itemType;

}
