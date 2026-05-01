package com.pravin.dashboard.controller;

import com.pravin.dashboard.dto.ProductResponse;
import com.pravin.dashboard.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/price")
@Validated
public class ProductController {

    private static final Logger log = LoggerFactory.getLogger(ProductController.class);
    private final ProductService productService;
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping(value = "/all")
     public ResponseEntity<List<ProductResponse>> getProducts() {
        log.info("Get all products");
        return ResponseEntity.ok(productService.getAllProducts());
    }

}
