package com.demo.application.dtos;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class AuthRequestDto {
    @NotBlank(message = "Subject cannot be empty")
    private String subject;
    @NotBlank(message = "Password cannot be empty")
    private String password;
}
