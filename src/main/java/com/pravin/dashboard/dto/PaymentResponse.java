package com.pravin.dashboard.dto;

import com.pravin.dashboard.entity.PaymentStatus;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record PaymentResponse(
        Long id,
        Long orderId,
        PaymentStatus status,
        BigDecimal amount,
        LocalDateTime createdAt
) {}