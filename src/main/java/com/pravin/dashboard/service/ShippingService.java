package com.pravin.dashboard.service;

import com.pravin.dashboard.component.DataMapper;
import com.pravin.dashboard.dto.ShipmentRequest;
import com.pravin.dashboard.dto.ShipmentResponse;
import com.pravin.dashboard.entity.Shipment;
import com.pravin.dashboard.entity.ShipmentStatus;
import com.pravin.dashboard.repository.ShipmentRepository;
import org.springframework.stereotype.Service;

@Service
public class ShippingService {

    private final ShipmentRepository repo;
    private final DataMapper dataMapper;

    public ShippingService(ShipmentRepository repo, DataMapper dataMapper) {
        this.repo = repo;
        this.dataMapper = dataMapper;
    }

    public ShipmentResponse create(ShipmentRequest shipmentRequest) {
        Shipment shipment = dataMapper.toEntity(shipmentRequest);
        shipment.setStatus(ShipmentStatus.CREATED);
        return  dataMapper.toResponse(repo.save(shipment));
    }
}