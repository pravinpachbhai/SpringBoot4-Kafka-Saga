package com.pravin.kafka.controller;

import com.pravin.kafka.entity.Inventory;
import com.pravin.kafka.service.InventoryService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/inventory")
public class InventoryController {

    private final InventoryService service;

    public InventoryController(InventoryService service) {
        this.service = service;
    }

    @GetMapping("/{productId}")
    public Inventory get(@PathVariable Long productId) {
        return service.get(productId);
    }

    @PostMapping("/reserve")
    public Inventory reserve(@RequestParam Long productId,
                             @RequestParam int quantity) {
        return service.reserve(productId, quantity);
    }
}