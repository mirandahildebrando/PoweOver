package com.PowerOver.PowerOver.controller;

import com.PowerOver.PowerOver.model.Sale;
import com.PowerOver.PowerOver.service.SaleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/sales")
public class SaleController {

    private final SaleService service;

    public SaleController(SaleService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Sale> create(@RequestBody Sale sale) {
        Sale salva = service.createSale(sale);
        return ResponseEntity.ok(salva);
    }

    @GetMapping
    public ResponseEntity<List<Sale>> getAll() {
        return ResponseEntity.ok(service.listAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Sale> getOne(@PathVariable Long id) {
        Sale s = service.findById(id);
        if (s != null) {
            return ResponseEntity.ok(s);
        }
        return ResponseEntity.notFound().build();
    }
}