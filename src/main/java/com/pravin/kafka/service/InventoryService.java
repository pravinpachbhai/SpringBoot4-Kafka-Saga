package com.pravin.kafka.service;

import com.pravin.kafka.entity.Inventory;
import com.pravin.kafka.exception.InsufficientStockException;
import com.pravin.kafka.exception.ResourceNotFoundException;
import com.pravin.kafka.repository.InventoryRepository;
import org.springframework.stereotype.Service;

@Service
public class InventoryService {

    private final InventoryRepository repo;

    public InventoryService(InventoryRepository repo) {
        this.repo = repo;
    }

    public Inventory get(Long productId) {
        return repo.findById(productId)
                .orElseThrow(() -> new ResourceNotFoundException("Inventory not found"));
    }

    public Inventory reserve(Long productId, int qty) {
        Inventory inv = get(productId);

        if (inv.getAvailableQuantity() < qty) {
            throw new InsufficientStockException("Not enough stock for product: " + productId);
        }

        inv.setAvailableQuantity(inv.getAvailableQuantity() - qty);
        inv.setReservedQuantity(inv.getReservedQuantity() + qty);

        return repo.save(inv);
    }
}