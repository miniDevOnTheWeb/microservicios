package com.example.orders_service.service;

import com.example.orders_service.client.ProductFeignClient;
import com.example.orders_service.client.UserFeignClient;
import com.example.orders_service.dto.OrderRequest;
import com.example.orders_service.entity.Order;
import com.example.orders_service.repository.OrderRepository;
import feign.FeignException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    private final OrderRepository orderRepository;
    private final ProductFeignClient productFeignClient;
    private final UserFeignClient userFeignClient;

    public OrderService(OrderRepository orderRepository, ProductFeignClient productFeignClient, UserFeignClient userFeignClient) {
        this.orderRepository = orderRepository;
        this.productFeignClient = productFeignClient;
        this.userFeignClient = userFeignClient;
    }

    public Order createOrder(OrderRequest request) {
        try {
            userFeignClient.userExistsById(request.getUserId());
        } catch (FeignException.NotFound ex) {
            throw new RuntimeException("El usuario no existe");
        }

        try {
            productFeignClient.productExistsById(request.getProductId());
        } catch (FeignException.NotFound ex) {
            throw new RuntimeException("El producto no existe");
        }


        Order order = new Order();
        order.setProductId(request.getProductId());
        order.setUserId(request.getUserId());
        order.setTotalAmount(request.getTotalAmount());

        return orderRepository.save(order);
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }
}
