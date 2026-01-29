package com.example.user_service;

import com.example.user_service.dto.AdminRequest;
import com.example.user_service.entity.Admin;
import com.example.user_service.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {
    private final UserService userService;

    public DataInitializer(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void run(String... args) throws Exception {
        String username = "administrator@gmail.com";
        String password = "password";

        if(!userService.existsByEmail(username)) {
            AdminRequest adminRequest = new AdminRequest();
            adminRequest.setPassword(password);
            adminRequest.setEmail(username);
            adminRequest.setAdminCode("898998989");
            adminRequest.setSuperAdmin(true);

            Admin admin = userService.createAdmin(adminRequest);

            if (admin.isEnabled()) {
                System.out.println("admin creado exitosamente con coreo y password : " + username + ", " + password);
            }
        }else {
            System.out.println("El admin ya existia");
        }
    }
}
