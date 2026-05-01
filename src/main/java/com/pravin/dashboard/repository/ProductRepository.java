package com.pravin.dashboard.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.pravin.dashboard.entity.Product;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}