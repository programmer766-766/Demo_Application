package com.demo.application.entity;

import io.swagger.v3.oas.annotations.media.Schema;
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
    @Schema(name = "Name",example = "Jhon wick")
    private String fullName;

    @Column(name = "EMAIL",unique = true)
    @Schema(name = "Email ",example = "abc@gmail.com")
    private String email;

    @Column(name = "CITY")
    @Schema(name = "City",example = "Erode")
    private String city;
}
