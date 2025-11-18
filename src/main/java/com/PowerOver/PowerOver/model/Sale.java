package com.PowerOver.PowerOver.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.Valid;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "sales")
@Data
@NoArgsConstructor
public class Sale {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private LocalDateTime dateSale;

    @NotNull
    private Double totalValue;

    @NotNull
    @Valid
    @OneToMany(mappedBy = "sale", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ItemSale> items;

    public void calculateTotalValue() {
        this.totalValue = 0.0;

        List<ItemSale> itemSale = this.getItems();

        for(int i = 0; i < itemSale.size(); i++) {
            ItemSale item = itemSale.get(i);
            double subTotalItem = item.getSubtotal();
            this.totalValue = this.totalValue + subTotalItem;
        }
    }
}