package main.java.com.PowerOver.PowerOver.dto;

import java.time.LocalDateTime;

public record SaleDTO(
    Long id, 
    LocalDateTime dateSale,
    Double totalValue,
    List<ItemSaleDTO> items
) {

}
