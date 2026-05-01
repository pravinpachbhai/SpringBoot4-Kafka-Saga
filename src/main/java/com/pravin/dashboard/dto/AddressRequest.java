package com.pravin.dashboard.dto;

public record AddressRequest(
        String addressLine,
        String city,
        String state,
        String zip
) {}