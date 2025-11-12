package com.PowerOver.PowerOver.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Data
@NoArgsConstructor
public class ItemSale {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer quantity;

    private double unitPrice;

    private double subtotal;

    @ManyToOne
    @JoinColumn(name = "productId")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "saleId")
    private Sale sale;

    public void calculateSubtotal() {
        subtotal = getUnitPrice() * getQuantity();
        System.out.println(getUnitPrice() + "X" + getQuantity() + "=" + subtotal);
    }



}
