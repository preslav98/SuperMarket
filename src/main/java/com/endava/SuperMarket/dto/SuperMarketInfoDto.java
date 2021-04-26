package com.endava.SuperMarket.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Getter
@Setter
@NoArgsConstructor
public class SuperMarketInfoDto {

    @NotBlank(message = "Field name cannot be blank.")
    private String marketName;

    @NotBlank(message = "Field address cannot be blank.")
    private String marketAddress;

    private String phoneNumber;

    private String workHours;
}
