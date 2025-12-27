package com.PowerOver.PowerOver.controller;

import com.PowerOver.PowerOver.dto.ProductDTO;
import com.PowerOver.PowerOver.model.Product;
import com.PowerOver.PowerOver.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

   
    @PostMapping
    public ResponseEntity<Product> create(@RequestBody ProductDTO dto) {
        Product novoProduto = productService.create(dto);
        return ResponseEntity.ok(novoProduto);
    }

   
    @GetMapping
    public ResponseEntity<List<Product>> listAll() {
        List<Product> lista = productService.listAll();
        return ResponseEntity.ok(lista);
    }

    
    @GetMapping("/{id}")
    public ResponseEntity<Product> getById(@PathVariable Long id) {
        Product p = productService.findById(id);
        
        if (p != null) {
            return ResponseEntity.ok(p);
        } else {
            
            return ResponseEntity.notFound().build();
        }
    }

    
    @PutMapping("/{id}")
    public ResponseEntity<Product> update(@PathVariable Long id, @RequestBody ProductDTO dto) {
        Product atualizado = productService.update(id, dto);
        
        if (atualizado != null) {
            return ResponseEntity.ok(atualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        
        productService.delete(id);
        
        return ResponseEntity.noContent().build();
    }
}