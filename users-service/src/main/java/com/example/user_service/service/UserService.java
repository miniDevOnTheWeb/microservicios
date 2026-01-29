package com.example.user_service.service;

import com.example.user_service.dto.AdminRequest;
import com.example.user_service.dto.ClientRequest;
import com.example.user_service.dto.UpdateUserRequest;
import com.example.user_service.entity.Admin;
import com.example.user_service.entity.Client;
import com.example.user_service.entity.UserEntity;
import com.example.user_service.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository,
                       PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public Client createClient(ClientRequest request) {
        Client client = new Client();
        client.setEmail(request.getEmail());
        client.setPassword(passwordEncoder.encode(request.getPassword()));
        client.setFirstName(request.getFirstName());
        client.setLastName(request.getLastName());
        client.setPhone(request.getPhone());

        return userRepository.save(client);
    }

    public Admin createAdmin(AdminRequest request) {
        Admin admin = new Admin();
        admin.setEmail(request.getEmail());
        admin.setPassword(passwordEncoder.encode(request.getPassword()));
        admin.setAdminCode(request.getAdminCode());
        admin.setSuperAdmin(request.isSuperAdmin());

        return userRepository.save(admin);
    }

    public UserEntity getById(UUID id) {
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
    }

    public UserEntity updateUser(UUID userId, UpdateUserRequest request) {
        UserEntity user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (user instanceof Client client) {
            if (request.getFirstName() != null)
                client.setFirstName(request.getFirstName());

            if (request.getLastName() != null)
                client.setLastName(request.getLastName());

            if (request.getPhone() != null)
                client.setPhone(request.getPhone());
        }

        if (request.getEnabled() != null)
            user.setEnabled(request.getEnabled());

        return userRepository.save(user);
    }

    public List<UserEntity> findAll () {
        return userRepository.findAll();
    }

    public boolean existsByEmail (String email) {
        return userRepository.existsByEmail(email);
    }
}