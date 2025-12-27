package com.PowerOver.PowerOver.service;

import com.PowerOver.PowerOver.dto.ProductDTO;
import com.PowerOver.PowerOver.model.Product;
import com.PowerOver.PowerOver.repository.ProductRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductService {
    private final ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public Product create(ProductDTO dto) {
        Product p = new Product();
        p.setProductName(dto.productName());
        p.setProductPrice(dto.productPrice());
        p.setProductQuantity(dto.productQuantity());
        return repository.save(p);
    }

    public List<Product> listAll() {
        return repository.findAll();
    }

    public Product findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Product update(Long id, ProductDTO dto) {
        Product p = findById(id);
        if (p != null) {
            p.setProductName(dto.productName());
            p.setProductPrice(dto.productPrice());
            p.setProductQuantity(dto.productQuantity());
            return repository.save(p);
        }
        return null;
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}