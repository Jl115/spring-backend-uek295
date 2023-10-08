package com.example.uek295_backeend.controller;

import com.example.uek295_backeend.entity.User;
import com.example.uek295_backeend.service.UserService;
import com.example.uek295_backeend.service.dtos.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
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
    public User createUser(@RequestBody User user) {
        return userService.create(user);
    }

    @PutMapping("/user/{id}")
    public UserDTO updateUser(@PathVariable Long id, @RequestBody UserDTO userDTO) {
        return userService.update(id, userDTO);
    }

    // DELETE Mapping to delete a user by ID
    @DeleteMapping("/user/{id}")
    public String deleteUser(@PathVariable Long id) {
        userService.delete(id);
        return "User with " + id + " deleted successfully";
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleExceptions(Exception ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
