package com.PowerOver.PowerOver.controller;

import com.PowerOver.PowerOver.model.Sale;
import com.PowerOver.PowerOver.service.SaleService;

import main.java.com.PowerOver.PowerOver.dto.SaleDTO;

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
    public ResponseEntity<SaleDTO> createSale(@RequestBody SaleDTO dto) {
        SaleDTO createdSaleDTO = saleService.createSale(dto);
        return ResponseEntity.status(201).body(createdSaleDTO);
    }

    @GetMapping
    public ResponseEntity<List<SaleDTO>> list() {
        List<SaleDTO> sales = saleService.listAllDTOs();
        if(sales.isEmpty()) {
            return ResponseEntity.noContent().build();
        } return ResponseEntity.ok(sales);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SaleDTO> getSaleById(@PathVariable Long id) {
        SaleDTO sale = saleService.getSaleById(id);
        if(sale == null){
            return ResponseEntity.notFound().build();
        } return ResponseEntity.ok(sale);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SaleDTO> updateSale(@PathVariable Long id, @RequestBody SaleTO dto){
        SaleDTO updateSale = saleService.updateSale(id, dto);
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
