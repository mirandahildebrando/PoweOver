package com.PowerOver.PowerOver.controller;

import com.PowerOver.PowerOver.model.Sale;
import com.PowerOver.PowerOver.service.SaleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sales")
public class SaleController {

    private final SaleService saleService;

    public SaleController(SaleService saleService) {
        this.saleService = saleService;
    }

    @PostMapping
    public Sale createSale(@RequestBody Sale sale) {
        return saleService.createSale(sale);
    }

    @GetMapping
    public List<Sale> list() {
        return saleService.list();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Sale> getSaleById(@PathVariable Long id) {
        Sale sale = saleService.getSaleById(id);
        if(sale == null){
            return ResponseEntity.notFound().build();
        } return ResponseEntity.ok(sale);
    }

    @PutMapping
    public ResponseEntity<Sale> updateSale(@PathVariable Long id, @RequestBody Sale sale){
        Sale updateSale = saleService.updateSale(id, sale);
        if(updateSale == null) {
            return ResponseEntity.notFound().build();
        } return ResponseEntity.ok(updateSale);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSale(@PathVariable Long id) {
        boolean delete = saleService.deleteSale(id);
        if(delete) {
            return ResponseEntity.noContent().build();
        } return ResponseEntity.notFound().build();

    }

}
