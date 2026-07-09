package com.demo.application.dtos;

import lombok.Data;

@Data
public class UserProfileDto {
    private Integer profileId;
    private String fullName;
    private String email;
    private String city;
}
