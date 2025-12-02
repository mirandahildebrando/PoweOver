package com.PowerOver.PowerOver.service;

import com.PowerOver.PowerOver.model.Product;
import com.PowerOver.PowerOver.model.Sale;
import com.PowerOver.PowerOver.repository.SaleRepository;

import main.java.com.PowerOver.PowerOver.dto.ItemSaleDTO;
import main.java.com.PowerOver.PowerOver.dto.ProductDTO;
import main.java.com.PowerOver.PowerOver.dto.SaleDTO;

import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class SaleService {

    private final SaleRepository saleRepository;

    public SaleService(SaleRepository saleRepository) {
        this.saleRepository = saleRepository;
    }

    public Sale createSale(Sale sale) {
        return saleRepository.save(sale);
    }

    public List<Sale> list() {
        Sort sort = Sort.by("dateSale").descending();
        return saleRepository.findAll();
    }

    public Sale getSaleById(Long id) {
        return saleRepository.findById(id).orElseThrow(() -> new RuntimeException("Venda não encontrada."));
    }

    public Sale updateSale(Long id, Sale saleDetails) {
        Sale sale = getSaleById(id);
        sale.setDateSale(saleDetails.getDateSale());
        sale.setItems(saleDetails.getItems());
        sale.setTotalValue(saleDetails.getTotalValue());
        return saleRepository.save(sale);
    }

    public boolean deleteSale(Long id) {
        if(saleRepository.existsById(id)) {
            saleRepository.deleteById(id);
            return true;
        } return false;
    }

    public SaleDTO toDTO(Sale sale) {
        List<ItemSaleDTO> itemDTOs = sale.getItems()
        .stream()
        .map(this::toItemSaleDTO)
        .toList();

        return new SaleDTO(
            sale.getId(),
            sale.getDateSale(),
            sale.getTotalValue(),
            itemDTOs
        );
    }

}
