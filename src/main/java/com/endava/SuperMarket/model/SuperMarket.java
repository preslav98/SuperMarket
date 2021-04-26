package com.endava.SuperMarket.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class SuperMarket extends BaseEntity {

    @NotBlank(message = "Field name cannot be blank.")
    @Size(max = 64)
    @Column(name = "name", unique = true)
    private String marketName;

    @NotBlank(message = "Field address cannot be blank.")
    @Size(max = 64)
    @Column(name = "address")
    private String marketAddress;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "work_hours")
    private String workHours;

    @ManyToMany
    @JoinTable(
            name = "supermarket_items",
            joinColumns = @JoinColumn(name = "supermarket_id"),
            inverseJoinColumns = @JoinColumn(name = "item_id"))
    private List<Item> items;
}
