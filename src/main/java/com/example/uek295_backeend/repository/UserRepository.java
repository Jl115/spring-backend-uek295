package com.example.uek295_backeend.repository;

import com.example.uek295_backeend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface UserRepository extends JpaRepository<User, Integer> {


    List<User> findAllByName(String name);
}



