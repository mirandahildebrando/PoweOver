package com.PowerOver.PowerOver.service;

import com.PowerOver.PowerOver.dto.ProductDTO;
import com.PowerOver.PowerOver.model.Product;
import com.PowerOver.PowerOver.repository.ProductRepository;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductService {
    private final ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public ProductDTO create(ProductDTO dto) {
        Product p = new Product();
        p.setProductName(dto.productName());
        p.setProductPrice(dto.productPrice());
        p.setProductQuantity(dto.productQuantity());

        Product saved = repository.save(p);

        return new ProductDTO(
            saved.getId(),
            saved.getProductName(),
            saved.getProductPrice(),
            saved.getProductQuantity()
        );
    }

    public List<ProductDTO> listAll() {
        Sort sort = Sort.by("productName").ascending();
        return repository.findAll(sort).stream()
                .map(product -> new ProductDTO(
                        product.getId(),
                        product.getProductName(),
                        product.getProductPrice(),
                        product.getProductQuantity()
                ))
                .toList();
    }

    public ProductDTO findById(Long id) {
        return repository.findById(id).map(product -> new ProductDTO(
                product.getId(),
                product.getProductName(),
                product.getProductPrice(),
                product.getProductQuantity()
        )).orElseThrow(() -> new RuntimeException("Produto não encontrado"));
    }

    public ProductDTO update(Long id, ProductDTO dto) {
        Product p = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));

        p.setProductName(dto.productName());
        p.setProductPrice(dto.productPrice());
        p.setProductQuantity(dto.productQuantity());

        Product updated = repository.save(p);

        return new ProductDTO(
                updated.getId(),
                updated.getProductName(),
                updated.getProductPrice(),
                updated.getProductQuantity()
        );
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}