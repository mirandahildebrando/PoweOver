package com.PowerOver.PowerOver.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Sale {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (nullable = false)
    private LocalDateTime dateSale;

    @Column (nullable = false)
    private Double totalValue;


    @OneToMany(mappedBy = "sale")
    private List<ItemSale> items;


    public void calculateTotalValue() {
        this.totalValue = 0.0;

        List<ItemSale> itemSale = this.getItems();

        for(int i = 0; i < itemSale.size(); i++) {

            ItemSale item = itemSale.get(i);

            double subTotalItem = item.getSubtotal();

            this.totalValue = this.totalValue + subTotalItem;

            System.out.println("Total: R$ " + totalValue);

        }

        }

}