package com.example.orders_service.client;

import com.example.orders_service.entity.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.UUID;

@FeignClient(name = "users-service")
public interface UserFeignClient {
    @GetMapping("/users/exists/{id}")
    Product userExistsById(
            @PathVariable("id") UUID id
    );
}
