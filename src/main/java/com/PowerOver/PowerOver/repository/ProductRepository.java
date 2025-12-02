package com.PowerOver.PowerOver.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.PowerOver.PowerOver.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    // Additional query methods can be defined here if needed

}
