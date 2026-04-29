package com.pravin.kafka.controller;

import com.pravin.kafka.dto.ShipmentRequest;
import com.pravin.kafka.dto.ShipmentResponse;
import com.pravin.kafka.entity.Shipment;
import com.pravin.kafka.service.ShippingService;
import org.springframework.web.bind.annotation.*;

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