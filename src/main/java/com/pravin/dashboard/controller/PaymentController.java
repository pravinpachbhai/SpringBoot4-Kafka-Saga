package com.pravin.dashboard.controller;

import com.pravin.dashboard.dto.PaymentRequest;
import com.pravin.dashboard.dto.PaymentResponse;
import com.pravin.dashboard.service.PaymentService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/payments")
public class PaymentController {

    private final PaymentService service;

    public PaymentController(PaymentService service) {
        this.service = service;
    }

    @PostMapping
    public PaymentResponse process(@RequestBody PaymentRequest payment) {
        return service.process(payment);
    }
}