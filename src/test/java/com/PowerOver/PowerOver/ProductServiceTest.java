package com.PowerOver.PowerOver;

import com.PowerOver.PowerOver.dto.ProductDTO;
import com.PowerOver.PowerOver.model.Product;
import com.PowerOver.PowerOver.repository.ProductRepository;
import com.PowerOver.PowerOver.service.ProductService;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ProductServiceTest {

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductService productService;

    @Test
    @DisplayName("Deve criar um novo produto")
    void testCreateProduct() {
        ProductDTO dto = new ProductDTO("Mouse", 50.0, 10);
        Product savedProduct = new Product();
        savedProduct.setId(1L);
        savedProduct.setProductName("Mouse");

        when(productRepository.save(any(Product.class))).thenReturn(savedProduct);

        Product result = productService.create(dto);

        assertNotNull(result);
        assertEquals("Mouse", result.getProductName());
        verify(productRepository, times(1)).save(any());

    }

}