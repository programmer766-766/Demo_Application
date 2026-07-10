package com.demo.application.repo;

import com.demo.application.entity.UserEntity;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity,Integer> {
    Optional<UserEntity> findByFullName(String fullName);

    //fetch all users
    @Query("SELECT u  FROM UserEntity u")
    List<UserEntity> getAllUsers();

    //fetch user by id
    @Query("SELECT u FROM UserEntity  u WHERE u.userId=:id")
    UserEntity getUser(@Param("id") int id);
}
