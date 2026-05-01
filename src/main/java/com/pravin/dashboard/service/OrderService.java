package com.pravin.dashboard.service;

import com.pravin.dashboard.component.DataMapper;
import com.pravin.dashboard.dto.OrderRequest;
import com.pravin.dashboard.dto.OrderResponse;
import com.pravin.dashboard.entity.Order;
import com.pravin.dashboard.entity.OrderStatus;
import com.pravin.dashboard.exception.ResourceNotFoundException;
import com.pravin.dashboard.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    private final OrderRepository repo;
    private final DataMapper dataMapper;

    public OrderService(OrderRepository repo, DataMapper dataMapper) {
        this.repo = repo;
        this.dataMapper = dataMapper;
    }

    public OrderResponse create(OrderRequest orderRequest) {
        Order order = dataMapper.toEntity(orderRequest);
        order.setStatus(OrderStatus.CREATED);
        return dataMapper.toResponse(repo.save(order));
    }

    public OrderResponse get(Long id) {
        Order order = repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Order not found with id: " + id));
        return dataMapper.toResponse(order);
    }

    public List<OrderResponse> getByUser(Long userId) {
        return repo.findByUserId(userId)
                .stream()
                .map(dataMapper::toResponse)
                .toList();
    }
}