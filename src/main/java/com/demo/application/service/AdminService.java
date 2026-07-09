package com.demo.application.service;

import com.demo.application.dtos.AdminAuthRequestDto;
import com.demo.application.entity.UserEntity;
import com.demo.application.repo.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/*
Admin class build only for Authorization purpose
without adding any spring security dependency
 */
@Service
public class AdminService {

    private final UserRepository userRepository;

    public AdminService(UserRepository userRepository){
        this.userRepository=userRepository;
    }
    //method will return all application users if username and password matches
    public List<UserEntity> getAllUsers(AdminAuthRequestDto authRequestDto){
        if(authRequestDto.getUsername().equals("admin")&&authRequestDto.getPassword().equals("admin@123")){
            return userRepository.findAll();
        }
        throw new RuntimeException("Request Forbidden");
    }
}
