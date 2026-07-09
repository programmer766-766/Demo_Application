package com.demo.application.service;

import com.demo.application.dtos.AddUserDto;
import com.demo.application.entity.UserEntity;
import com.demo.application.repo.UserRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
@Getter
public class UDServiceImpl implements UDService{

    private UserRepository userRepository;

    @Override
    public ResponseEntity<UserEntity> updateUser(int id, AddUserDto addUserDto) {

    UserEntity user = userRepository.findById(id).get();
    user.setCity(addUserDto.getCity());
    user.setEmail(addUserDto.getEmail());
    user.setFullName(addUserDto.getFullName());
    userRepository.save(user);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<UserEntity> deleteUser(int id) {

        UserEntity user = userRepository.findById(id).get();
        userRepository.deleteById(id);
        return new ResponseEntity<>(user, HttpStatus.OK) ;
    }

    @Override
    public ResponseEntity<List<UserEntity>> getAllUsers() {
        return new ResponseEntity<>(userRepository.findAll(), HttpStatus.OK);
    }

    @Override
    public boolean existsUser(int id) {
        return userRepository.existsById(id);
    }
}
