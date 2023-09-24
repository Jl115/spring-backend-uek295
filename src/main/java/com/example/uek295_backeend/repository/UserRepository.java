package com.example.uek295_backeend.repository;

import com.example.uek295_backeend.database.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface UserRepository extends JpaRepository<User, Integer> {


    List<User> findAllByName(String name);
}



