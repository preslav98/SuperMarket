package com.endava.SuperMarket.model;

import com.endava.SuperMarket.model.enums.ItemType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Getter
@Setter
public class Item extends BaseEntity{

    @NotBlank(message = "Field name cannot be blank.")
    @Column(name = "name")
    private String itemName;

    @NotNull(message = "Field price cannot be null.")
    @Column(name = "price")
    private Double price;

    @Enumerated(EnumType.STRING)
    @NotNull(message = "Field item type cannot be null.")
    @Column(name = "item_type")
    private ItemType itemType;

    @ManyToMany(mappedBy = "items")
    private List<SuperMarket> superMarkets;

    @ManyToMany(mappedBy = "items")
    private List<Purchase> purchase;
}
