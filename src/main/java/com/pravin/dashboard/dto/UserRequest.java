package com.pravin.dashboard.dto;

import java.util.List;

public record UserRequest(
        String name,
        String email,
        String password,
        List<AddressRequest> addresses
) {}
