package com.pravin.kafka.controller;

import com.pravin.kafka.entity.Payment;
import com.pravin.kafka.service.PaymentService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payments")
public class PaymentController {

    private final PaymentService service;

    public PaymentController(PaymentService service) {
        this.service = service;
    }

    @PostMapping
    public Payment process(@RequestBody Payment payment) {
        return service.process(payment);
    }
}