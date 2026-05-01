package com.pravin.dashboard.dto;

public record NotificationRequest(
        String type,
        String recipient,
        String message
) {}
