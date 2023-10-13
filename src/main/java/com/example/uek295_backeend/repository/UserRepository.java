package com.example.uek295_backeend.repository;

import com.example.uek295_backeend.entity.User;
import com.example.uek295_backeend.service.dtos.UserAuthDTO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface UserRepository extends JpaRepository<User, Integer> {


    Optional <User> findAllByName(String name);
}



