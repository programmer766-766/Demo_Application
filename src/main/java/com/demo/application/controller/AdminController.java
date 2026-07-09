package com.demo.application.controller;

import com.demo.application.dtos.AdminAuthRequestDto;
import com.demo.application.entity.UserEntity;
import com.demo.application.service.AdminService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    private final AdminService adminService;

    public AdminController(AdminService adminService){
        this.adminService=adminService;
    }
    @GetMapping("/app-users")
    public ResponseEntity<List<UserEntity>> getAllUsers(@RequestBody AdminAuthRequestDto authRequestDto){
        if(authRequestDto.getUsername()==null&&authRequestDto.getPassword()==null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok(adminService.getAllUsers(authRequestDto));
    }
}
