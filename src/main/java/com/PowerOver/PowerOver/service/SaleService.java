package com.PowerOver.PowerOver.service;

import com.PowerOver.PowerOver.model.Sale;
import com.PowerOver.PowerOver.model.ItemSale;
import com.PowerOver.PowerOver.model.Product;
import com.PowerOver.PowerOver.repository.SaleRepository;
import com.PowerOver.PowerOver.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaleService {

    private final SaleRepository saleRepository;
    private final ProductRepository productRepository;

    public SaleService(SaleRepository saleRepository, ProductRepository productRepository) {
        this.saleRepository = saleRepository;
        this.productRepository = productRepository;
    }

    public Sale createSale(Sale sale) {

        double total = 0.0;

        for (ItemSale item : sale.getItems()) {

            Product product = productRepository.findById(item.getProduct().getId())
                    .orElseThrow(() -> new RuntimeException("Produto não encontrado"));

            item.setProduct(product);
            item.setSale(sale);

            double subTotal = product.getProductPrice() * item.getQuantity();
            item.setSubtotal(subTotal);

            total += subTotal;
        }

        sale.setTotalValue(total);

        return saleRepository.save(sale);
    }

    public List<Sale> listAll() {
        return saleRepository.findAll();
    }

    public Sale findById(Long id) {
        return saleRepository.findById(id).orElse(null);
    }

    public void delete(Long id) {
        saleRepository.deleteById(id);
    }
}