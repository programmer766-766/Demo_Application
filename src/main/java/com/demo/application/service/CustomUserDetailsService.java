package com.demo.application.service;

import com.demo.application.entity.UserEntity;
import com.demo.application.repo.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class CustomUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;
    public CustomUserDetailsService(UserRepository userRepository){
        this.userRepository=userRepository;
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserEntity userEntity = userRepository.fetchUserByUsername(username).orElseThrow(() ->
                new UsernameNotFoundException("User not found :" + username));
        return new CustomUserDetails(userEntity);
    }
}
