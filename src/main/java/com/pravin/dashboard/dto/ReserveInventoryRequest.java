package com.pravin.dashboard.dto;

public record ReserveInventoryRequest(
        Long productId,
        Integer quantity
) {}