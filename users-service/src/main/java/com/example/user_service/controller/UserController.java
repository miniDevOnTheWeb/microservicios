package com.example.user_service.controller;

import com.example.user_service.entity.UserEntity;
import com.example.user_service.service.UserService;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public ResponseEntity<?> findAll () {
        return ResponseEntity.status(200).body(userService.findAll());
    }

    @GetMapping("/exists/{id}")
    public ResponseEntity<?> existsById (@PathVariable("id") UUID id) {
        userService.existsById(id);
        return ResponseEntity.ok().build();
    }
}
