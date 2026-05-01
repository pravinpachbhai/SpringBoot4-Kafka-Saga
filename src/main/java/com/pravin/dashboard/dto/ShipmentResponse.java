package com.pravin.dashboard.dto;

import com.pravin.dashboard.entity.ShipmentStatus;

import java.time.LocalDateTime;

public record ShipmentResponse(
        Long id,
        Long orderId,
        ShipmentStatus status,
        String trackingNumber,
        LocalDateTime createdAt
) {}