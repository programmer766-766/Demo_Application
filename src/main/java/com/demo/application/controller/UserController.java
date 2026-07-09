package com.demo.application.controller;

import com.demo.application.dtos.AddUserDto;
import com.demo.application.dtos.UserProfileDto;
import com.demo.application.entity.UserEntity;
import com.demo.application.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService){
        this.userService=userService;
    }

    @PostMapping("/add-user")
    public ResponseEntity<UserEntity> addUser(@RequestBody AddUserDto addUserDto){
        if(addUserDto.getFullName()==null||addUserDto.getEmail()==null||addUserDto.getCity()==null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.createAnUser(addUserDto));
    }
    @GetMapping("/profile/{id}")
    public ResponseEntity<UserProfileDto> getUserProfile(@PathVariable int id){
        return ResponseEntity.ok(userService.userProfile(id));
    }
}
