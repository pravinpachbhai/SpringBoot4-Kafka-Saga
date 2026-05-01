package com.pravin.dashboard.dto;

public record InventoryResponse(
        Long productId,
        Integer availableQuantity,
        Integer reservedQuantity
) {}