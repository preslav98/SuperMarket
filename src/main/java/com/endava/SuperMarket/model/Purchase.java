package com.endava.SuperMarket.model;

import com.endava.SuperMarket.model.enums.PaymentType;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

@Entity
@Builder
@Setter
@Getter
@AllArgsConstructor
public class Purchase extends BaseEntity{

    @Column(name = "supermarket_id")
    @NotBlank(message = "Field supermarket_id cannot be blank.")
    private String superMarketId;

    @ManyToMany
    @JoinTable(
            name = "purchase_item",
            joinColumns = @JoinColumn(name = "purchase_id"),
            inverseJoinColumns = @JoinColumn(name = "item_id"))
    private List<Item> items;

    @Column(name = "purchase_change")
    private Double change;

    @Column(name = "total_cost")
    @NotNull(message = "Field total_cost cannot be null.")
    private Double totalCost;

    @Column(name = "purchase_date")
    @NotNull(message = "Field purchase_date cannot be null.")
    private LocalDate dateOfPurchase;

    @Column(name = "payment_type")
    @Enumerated(EnumType.STRING)
    @NotNull(message = "Field payment_type cannot be null.")
    private PaymentType paymentType;
}
