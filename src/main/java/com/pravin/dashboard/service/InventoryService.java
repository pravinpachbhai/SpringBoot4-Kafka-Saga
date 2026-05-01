package com.pravin.dashboard.service;

import com.pravin.dashboard.component.DataMapper;
import com.pravin.dashboard.dto.InventoryResponse;
import com.pravin.dashboard.entity.Inventory;
import com.pravin.dashboard.exception.InsufficientStockException;
import com.pravin.dashboard.exception.ResourceNotFoundException;
import com.pravin.dashboard.repository.InventoryRepository;
import org.springframework.stereotype.Service;

@Service
public class InventoryService {

    private final InventoryRepository repo;
    private final DataMapper dataMapper;
    public InventoryService(InventoryRepository repo, DataMapper dataMapper) {
        this.repo = repo;
        this.dataMapper = dataMapper;
    }

    public InventoryResponse get(Long productId) {
        Inventory inventory =  repo.findById(productId)
                .orElseThrow(() -> new ResourceNotFoundException("Inventory not found"));
        return dataMapper.toResponse(inventory);
    }

    public InventoryResponse reserve(Long productId, int qty) {
        Inventory inventory =  repo.findById(productId)
                .orElseThrow(() -> new ResourceNotFoundException("Inventory not found"));

        if (inventory.getAvailableQuantity() < qty) {
            throw new InsufficientStockException("Not enough stock for product: " + productId);
        }

        inventory.setAvailableQuantity(inventory.getAvailableQuantity() - qty);
        inventory.setReservedQuantity(inventory.getReservedQuantity() + qty);

        return dataMapper.toResponse(repo.save(inventory));
    }
}