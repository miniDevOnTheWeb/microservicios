package com.example.orders_service.controller;

import com.example.orders_service.dto.OrderRequest;
import com.example.orders_service.entity.Order;
import com.example.orders_service.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    public ResponseEntity<?> createOrder(@RequestBody OrderRequest request) {
        Order order = orderService.createOrder(request);

        return ResponseEntity.status(HttpStatus.CREATED).body(Map.of(
                "message", "Order registrada",
                "order", order
        ));
    }

    @GetMapping
    public ResponseEntity<?> getAllOrders() {
        return ResponseEntity.status(HttpStatus.CREATED).body(Map.of(
                "order", orderService.getAllOrders()
        ));
    }
}
