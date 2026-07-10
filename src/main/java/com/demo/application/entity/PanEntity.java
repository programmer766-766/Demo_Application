package com.demo.application.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
@Entity
@Data
public class PanEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer panId;
    private String panNumber;
    private String city;
    private LocalDateTime appliedDate;
    @OneToOne
    @JoinColumn(name = "user-id")
    private UserEntity userId;
}
