package main.java.com.PowerOver.PowerOver.dto;

public record ItemSaleDTO(
    Long id, 
    Integer quantity,
    double unitPrice,
    double subtotal,
    Long productId
) {

}
