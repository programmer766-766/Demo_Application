package com.demo.application.controller;

import com.demo.application.dtos.*;
import com.demo.application.entity.PanEntity;
import com.demo.application.entity.UserEntity;
import com.demo.application.service.JwtService;
import com.demo.application.service.UserService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    private final UserService userService;
    private final JwtService jwtService;
    public UserController(UserService userService,JwtService jwtService){
        this.userService=userService;
        this.jwtService=jwtService;
    }
@ApiResponses(value = {
        @ApiResponse(responseCode = "201",description = "successfully posted")
})
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
    @GetMapping("/users")
    public ResponseEntity<List<UserEntity>> fetchAllUsers(){
        return ResponseEntity.ok(userService.fetchAllUsers());
    }

    @PutMapping("/update/{email}/{id}")
    public ResponseEntity<Integer> updateUser(@PathVariable String email,@PathVariable int id){
        return ResponseEntity.ok(userService.updateUserEmail(email,id));
    }
    @DeleteMapping("delete/{id}")
    public ResponseEntity<Integer> deleteUser(@PathVariable int id){
        return ResponseEntity.ok(userService.deleteUser(id));
    }
    @PostMapping("/add-pan/{userId}/{decideNum}")
    public ResponseEntity<PanEntity> addPanDetails(@PathVariable int userId,@PathVariable int decideNum){
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.addPanCardDetails(userId,decideNum));
    }

    @PostMapping("/auth")
    public ResponseEntity<AuthResponseDto> authenticateUser(@Valid@RequestBody AuthRequestDto authRequestDto){
        UsernamePasswordAuthenticationToken authenticationToken=
                new UsernamePasswordAuthenticationToken(authRequestDto.getSubject(),authRequestDto.getPassword());
        //generate token if authentication is valid
        if(authenticationToken.isAuthenticated()){
            String token= jwtService.generateToken(authRequestDto.getSubject());
            return ResponseEntity.ok(new AuthResponseDto(authRequestDto.getSubject(),token));
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }

}
