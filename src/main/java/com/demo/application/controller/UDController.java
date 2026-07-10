package com.demo.application.controller;

import com.demo.application.dtos.AddUserDto;
import com.demo.application.entity.UserEntity;
import com.demo.application.exception.IdNotFoundException;
import com.demo.application.service.UDService;
import com.demo.application.service.UDServiceImpl;
import com.demo.application.util.Util;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ud")
@AllArgsConstructor
public class UDController{

    private UDService udService;

    @ApiResponses(value = {
        @ApiResponse(responseCode = "404",description = "there is no id")
})
    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateUser(@RequestBody AddUserDto addUserDto,@PathVariable int id){
        if (!udService.existsUser(id))
            throw Util.idNotFound();
        return new ResponseEntity<>(udService.updateUser(id,addUserDto).getBody().getFullName(), HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteUser(@RequestParam int id){
        if (!udService.existsUser(id))
            throw Util.idNotFound();
        return new ResponseEntity<>(udService.deleteUser(id).getBody().getFullName(), HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<List<UserEntity>> getAllUsers(){
       return new ResponseEntity<>(udService.getAllUsers().getBody(),HttpStatus.OK);
    }
}
