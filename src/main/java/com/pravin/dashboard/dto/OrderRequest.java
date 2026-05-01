package com.pravin.dashboard.dto;

import java.util.List;

public record OrderRequest(
        Long userId,
        List<OrderItemRequest> items
) {}