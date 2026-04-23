package com.PowerOver.PowerOver.service;

import com.PowerOver.PowerOver.model.Sale;
import com.PowerOver.PowerOver.model.ItemSale;
import com.PowerOver.PowerOver.repository.SaleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaleService {

    private final SaleRepository saleRepository;

    public SaleService(SaleRepository saleRepository) {
        this.saleRepository = saleRepository;
    }

    public Sale createSale(Sale sale) {

        double total = 0.0;

        List<ItemSale> listaDeItens = sale.getItems();

        for (ItemSale item : listaDeItens) {

            item.setSale(sale);
            double subTotal = item.getProduct().getProductPrice() * item.getQuantity();
            item.setSubTotal(subTotal);

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