package com.example.spring.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "users")

public class user {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String full_name;
    private String email;
    private  String password;
}
