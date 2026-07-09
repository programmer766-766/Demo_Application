package com.demo.application.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "USER_TABLE")
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer userId;
    @Column(name = "FULL NAME")
    private String fullName;
    @Column(name = "EMAIL",unique = true)
    private String email;
    @Column(name = "CITY")
    private String city;
}
