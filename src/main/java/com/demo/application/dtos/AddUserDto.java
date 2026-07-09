package com.demo.application.dtos;

import lombok.Data;

@Data
public class AddUserDto {
    private String fullName;
    private String email;
    private String city;
}
