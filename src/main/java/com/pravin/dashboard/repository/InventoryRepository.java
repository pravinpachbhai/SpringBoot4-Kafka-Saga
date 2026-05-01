package com.pravin.dashboard.repository;

import com.pravin.dashboard.entity.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryRepository extends JpaRepository<Inventory, Long> {
}