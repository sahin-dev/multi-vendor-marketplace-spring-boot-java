package com.bestkid.bestkid_api.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;

public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @Min(1)
    private Integer quantity;
    
    private Product product;

    private Float unitPrice;
    
    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    
}
