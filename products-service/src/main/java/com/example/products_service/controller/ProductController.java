package com.example.products_service.controller;

import com.example.products_service.dto.ProductRequest;
import com.example.products_service.entity.Product;
import com.example.products_service.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public ResponseEntity<Product> create(@RequestBody ProductRequest product) {
        Product savedProduct = productService.save(product);
        return new ResponseEntity<>(savedProduct, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Product>> findAll() {
        return ResponseEntity.ok(productService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> findById(@PathVariable UUID id) {
        return ResponseEntity.ok(productService.findById(id));
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<Product> findByName(@PathVariable String name) {
        Product product = productService.findByName(name);
        return ResponseEntity.ok(product);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> update(
            @PathVariable UUID id,
            @RequestBody ProductRequest product
    ) {
        return ResponseEntity.ok(productService.editProduct(id, product));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable UUID id) {
        productService.deleteById(id);
        return ResponseEntity.status(200).body(Map.of(
                "message", "producto eliminado"
        ));
    }

    @DeleteMapping
    public ResponseEntity<?> deleteAll() {
        productService.deleteAll();
        return ResponseEntity.status(200).body(Map.of(
                "message", "productos eliminados"
        ));
    }
}
