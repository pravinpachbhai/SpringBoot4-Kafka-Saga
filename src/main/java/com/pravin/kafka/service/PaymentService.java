package com.pravin.kafka.service;

import com.pravin.kafka.entity.Payment;
import com.pravin.kafka.entity.PaymentStatus;
import com.pravin.kafka.repository.PaymentRepository;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    private final PaymentRepository repo;

    public PaymentService(PaymentRepository repo) {
        this.repo = repo;
    }

    public Payment process(Payment payment) {
        payment.setStatus(PaymentStatus.SUCCESS);
        return repo.save(payment);
    }
}