package com.example.uek295_backeend.controller;


import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
public class UserController {

    // GET Mapping to get a specific user by ID
    @GetMapping("/{id}")
    public String getUserById(@PathVariable String id) {
        return "User GET by ID works, ID is: " + id;
    }

    // GET Mapping to get all users
    @GetMapping("/")
    public String getUsers() {
        return "Users GET works";
    }

    // POST Mapping to create a new user
    @PostMapping("/")
    public String postUser() {
        return "User POST works";
    }

    // DELETE Mapping to delete a user by ID
    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable String id) {

        return id + "deleted";
    }


}
