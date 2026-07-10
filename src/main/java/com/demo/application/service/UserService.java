package com.demo.application.service;

import com.demo.application.dtos.AddUserDto;
import com.demo.application.dtos.UserProfileDto;
import com.demo.application.entity.PanEntity;
import com.demo.application.entity.UserEntity;
import com.demo.application.repo.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    public UserService(UserRepository userRepository,PasswordEncoder passwordEncoder){
        this.userRepository=userRepository;
        this.passwordEncoder=passwordEncoder;
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
            adduser.setUserName(userDto.getUsername());
            adduser.setPassword(passwordEncoder.encode(userDto.getPassword()));
            adduser.setRole(userDto.getRole());

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
        UserEntity userEntity = userRepository.getUser(id).orElseThrow();
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

    public int updateUserEmail(String email,int id){
       return userRepository.updateUserEmail(email, id);
    }

    public int deleteUser(int id){
        return userRepository.deleteUser(id);
    }

    private List<String> panNumberList(){
        return  List.of("abc123,xyz789,kbvgt54,jydghj3");
    }

    public PanEntity addPanCardDetails(int userid,int decidedNumber){
        try {
            UserEntity user = userRepository.getUser(userid).orElseThrow(() ->
                    new RuntimeException("Id not found:" + userid));
            PanEntity panEntity = new PanEntity();
            panEntity.setPanNumber(panNumberList().get(decidedNumber));
            panEntity.setUserId(user);
            panEntity.setAppliedDate(LocalDateTime.now());
            panEntity.setCity("yxz");

            return panEntity;
        }
        catch (ArrayIndexOutOfBoundsException e){
            throw new RuntimeException("Decided number not available");
        }
    }

//    public UserEntity viewPanAloneWithUser(int userId){
//        UserEntity userEntity = userRepository.getUser(userId).orElseThrow(() ->
//                new RuntimeException("user not found:" + userId));
//
//    }
}
