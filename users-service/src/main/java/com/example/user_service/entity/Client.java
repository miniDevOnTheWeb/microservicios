package com.example.user_service.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@DiscriminatorValue("CLIENT")
public class Client extends UserEntity {
    private String firstName;
    private String lastName;
    private String phone;
}
