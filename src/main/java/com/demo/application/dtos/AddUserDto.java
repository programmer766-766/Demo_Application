package com.demo.application.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class AddUserDto {

    @NotBlank(message = "fullName cannot be empty")
    private String fullName;
    @Email(message = "email cannot be empty")
    private String email;
    @NotBlank(message = "city cannot be empty")
    private String city;
    @NotBlank(message = "username cannot be empty")
    private String username;
    @NotBlank(message = "password cannot be empty")
    private String password;
    @NotBlank
    private String role;
}
