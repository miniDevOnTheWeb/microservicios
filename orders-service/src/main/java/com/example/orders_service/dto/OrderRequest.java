package com.example.orders_service.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
public class OrderRequest {
    private UUID productId;
    private UUID userId;
    private BigDecimal totalAmount;
}
