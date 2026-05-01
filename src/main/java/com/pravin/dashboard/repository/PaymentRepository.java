package com.pravin.dashboard.repository;

import com.pravin.dashboard.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
}