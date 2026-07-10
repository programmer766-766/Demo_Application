package com.demo.application.repo;

import com.demo.application.entity.UserEntity;
import jakarta.transaction.Transactional;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
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
    Optional<UserEntity> getUser(@Param("id") int id);

    //update user email
    @Modifying
    @Transactional
    @Query("UPDATE UserEntity u SET u.email=:email WHERE u.userId=:id")
    int updateUserEmail(@Param("email")String email,@Param("id")int id);

    //delete user
    @Modifying
    @Transactional
    @Query("DELETE FROM UserEntity u WHERE u.userId=:id")
    int deleteUser(@Param("id")int id);

    //fetch user by username
    @Query("SELECT u FROM UserEntity u WHERE u.userName=:username")
    Optional<UserEntity> fetchUserByUsername(@Param("username")String username);
}
