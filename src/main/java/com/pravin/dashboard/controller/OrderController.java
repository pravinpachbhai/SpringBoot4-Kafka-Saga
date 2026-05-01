package com.pravin.dashboard.controller;

import com.pravin.dashboard.dto.OrderRequest;
import com.pravin.dashboard.dto.OrderResponse;
import com.pravin.dashboard.service.OrderService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/orders")
public class OrderController {

    private final OrderService service;

    public OrderController(OrderService service) {
        this.service = service;
    }

    @PostMapping
    public OrderResponse create(@RequestBody OrderRequest order) {
        return service.create(order);
    }

    @GetMapping("/{id}")
    public OrderResponse get(@PathVariable Long id) {
        return service.get(id);
    }

    @GetMapping("/user/{userId}")
    public List<OrderResponse> getByUser(@PathVariable Long userId) {
        return service.getByUser(userId);
    }
}