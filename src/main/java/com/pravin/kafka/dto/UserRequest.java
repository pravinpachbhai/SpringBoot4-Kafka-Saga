package com.pravin.kafka.dto;

public record UserRequest(
        String name,
        String email,
        String password
) {}
