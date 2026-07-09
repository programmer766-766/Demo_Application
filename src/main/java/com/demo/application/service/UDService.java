package com.demo.application.service;

import com.demo.application.dtos.AddUserDto;
import com.demo.application.entity.UserEntity;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UDService {

    ResponseEntity<UserEntity>updateUser(int id, AddUserDto addUserDto);
    ResponseEntity<UserEntity>deleteUser(int id);
    ResponseEntity<List<UserEntity>>getAllUsers();
}
