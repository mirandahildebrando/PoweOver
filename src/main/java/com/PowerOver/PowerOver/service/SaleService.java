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
        List<ItemSale> listaDeItens = sale.getItems();
        
        for (int i = 0; i < listaDeItens.size(); i++) {
            ItemSale item = listaDeItens.get(i);
            item.setSale(sale); 
        }

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