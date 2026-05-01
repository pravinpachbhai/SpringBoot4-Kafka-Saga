package com.pravin.dashboard.repository;

import com.pravin.dashboard.entity.Shipment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShipmentRepository extends JpaRepository<Shipment, Long> {
}