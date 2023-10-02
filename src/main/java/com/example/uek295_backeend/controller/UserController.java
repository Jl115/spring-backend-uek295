package com.example.uek295_backeend.controller;


import com.example.uek295_backeend.service.UserService;
import com.example.uek295_backeend.service.dtos.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class UserController {

    @Autowired
    private UserService userService;

    // GET Mapping to get a specific user by ID
    @GetMapping("/user/{id}")
    public UserDTO getUserById(@PathVariable Long id) {
        return userService.getById(id);
    }

    // GET Mapping to get all users
    @GetMapping("/user")
    public List<UserDTO> getAllUsers() {
        return userService.getAll();
    }

    // POST Mapping to create a new user
    @PostMapping("/user")
    public UserDTO createUser(@RequestBody UserDTO userDTO) {
        return userService.create(userDTO);
    }

    @PutMapping("/user/{id}")
    public UserDTO updateUser(@PathVariable Long id, @RequestBody UserDTO userDTO ) {
        return userService.update(id, userDTO);
    }

    // DELETE Mapping to delete a user by ID
    @DeleteMapping("/user/{id}")
    public String deleteUser(@PathVariable Long id) {
        userService.delete(id);
        return "User with " + id + "deleted successfully";
    }


}
