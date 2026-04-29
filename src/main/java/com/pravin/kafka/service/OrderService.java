package com.pravin.kafka.service;

import com.pravin.kafka.entity.Order;
import com.pravin.kafka.entity.OrderStatus;
import com.pravin.kafka.exception.ResourceNotFoundException;
import com.pravin.kafka.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    private final OrderRepository repo;

    public OrderService(OrderRepository repo) {
        this.repo = repo;
    }

    public Order create(Order order) {
        order.setStatus(OrderStatus.CREATED);
        return repo.save(order);
    }

    public Order get(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Order not found with id: " + id));
    }

    public List<Order> getByUser(Long userId) {
        return repo.findByUserId(userId);
    }
}