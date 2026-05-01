package com.pravin.dashboard.controller;

import com.pravin.dashboard.dto.ShipmentRequest;
import com.pravin.dashboard.dto.ShipmentResponse;
import com.pravin.dashboard.service.ShippingService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/shipments")
public class ShippingController {

    private final ShippingService service;

    public ShippingController(ShippingService service) {
        this.service = service;
    }

    @PostMapping
    public ShipmentResponse create(@RequestBody ShipmentRequest shipment) {
        return service.create(shipment);
    }
}