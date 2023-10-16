package com.example.uek295_backeend.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface UserRepository extends JpaRepository<User, Integer> {


    Optional <User> findAllByName(String name);

    User findByName(String name);

}



