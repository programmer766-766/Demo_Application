package com.demo.application.dtos;

import lombok.Data;

@Data
public class AdminAuthRequestDto {
    private String username;
    private String password;
}
