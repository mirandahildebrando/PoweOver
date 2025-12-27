package com.PowerOver.PowerOver.model;

import jakarta.persistence.*;
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
    private LocalDateTime dateSale;
    private Double totalValue;

    @OneToMany(mappedBy = "sale", cascade = CascadeType.ALL)
    private List<ItemSale> items;
}