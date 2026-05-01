package com.pravin.dashboard.service;

import com.pravin.dashboard.component.DataMapper;
import com.pravin.dashboard.dto.PaymentRequest;
import com.pravin.dashboard.dto.PaymentResponse;
import com.pravin.dashboard.entity.Payment;
import com.pravin.dashboard.entity.PaymentStatus;
import com.pravin.dashboard.repository.PaymentRepository;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    private final PaymentRepository repo;
    private final DataMapper dataMapper;
    public PaymentService(PaymentRepository repo, DataMapper dataMapper) {
        this.repo = repo;
        this.dataMapper = dataMapper;
    }

    public PaymentResponse process(PaymentRequest paymentRequest) {
        Payment payment = dataMapper.toEntity(paymentRequest);
        payment.setStatus(PaymentStatus.SUCCESS);
        return dataMapper.toResponse(repo.save(payment));
    }
}