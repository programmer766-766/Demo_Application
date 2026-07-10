package com.demo.application.service;

import com.demo.application.dtos.AddUserDto;
import com.demo.application.dtos.UserProfileDto;
import com.demo.application.entity.UserEntity;
import com.demo.application.repo.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;
    public UserService(UserRepository userRepository){
        this.userRepository=userRepository;
    }
    //method to add user in db
    public UserEntity createAnUser(AddUserDto userDto){
        //try catch is for handle the duplicate email
        try {
            //Add user and store into the db
            UserEntity adduser = new UserEntity();
            adduser.setFullName(userDto.getFullName());
            adduser.setEmail(userDto.getEmail());
            adduser.setCity(userDto.getCity());

            userRepository.save(adduser);

            return adduser;
        }
        catch (Exception e) {
           throw new RuntimeException("problem occured/email already registered");
        }
    }
    //method is for view user profile by their given name
    public UserProfileDto userProfile(int id){
        //Fetch user into DB by their input name
        UserEntity userEntity = userRepository.getUser(id);
        //if user exists map their details into UserProfileDto
        UserProfileDto userProfileDto=new UserProfileDto();
        userProfileDto.setProfileId(userEntity.getUserId());
        userProfileDto.setFullName(userEntity.getFullName());
        userProfileDto.setEmail(userEntity.getEmail());
        userProfileDto.setCity(userEntity.getCity());

        return userProfileDto;
    }

    //fetch all users using jpql
    public List<UserEntity> fetchAllUsers(){
        return userRepository.getAllUsers();
    }
}
