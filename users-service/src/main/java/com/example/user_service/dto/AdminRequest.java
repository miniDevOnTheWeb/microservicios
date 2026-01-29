package com.example.user_service.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class AdminRequest {
    @Email
    @NotBlank(message = "El correo del admin falta")
    private String email;
    @NotBlank(message = "contrasenia requerida")
    private String password;
    @NotBlank(message = "Codigo de admin requerido")
    private String adminCode;
    private boolean superAdmin;
}
