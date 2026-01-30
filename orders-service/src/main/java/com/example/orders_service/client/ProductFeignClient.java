package com.example.orders_service.client;

import com.example.orders_service.entity.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.UUID;

@FeignClient(name = "products-service", url = "http://localhost:8083")
public interface ProductFeignClient {
    @GetMapping("/products/exists/{id}")
    Product productExistsById(
            @PathVariable("id") UUID id
    );
}
