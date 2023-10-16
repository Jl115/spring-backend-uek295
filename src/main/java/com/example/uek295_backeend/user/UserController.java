package com.example.uek295_backeend.user;

import com.example.uek295_backeend.user.UserService;
import com.example.uek295_backeend.user.UserAuthDTO;
import com.example.uek295_backeend.user.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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
    public UserAuthDTO createUser(@RequestBody UserAuthDTO userAuthDTO) {
        return userService.create(userAuthDTO);
    }

    //put mapping to update a user
    @PutMapping("/user/{id}")
    public UserDTO updateUser(@PathVariable Long id, @RequestBody UserDTO userDTO) {
        return userService.update(id, userDTO);
    }


    //TODO immplementing promote to admin

    @PostMapping("/user/promote/{userId}")
    @PreAuthorize("hasRole('ADMIN')")  // Ensure that only admins can access this endpoint
    public ResponseEntity<String> promoteToAdmin(@PathVariable int userId) {
        userService.promoteToAdmin(userId);
        return ResponseEntity.ok("User promoted to admin successfully");
    }

    @PutMapping("/user/{id}/admin")
    public UserAuthDTO updateToAdmin(@PathVariable Long id, @RequestBody UserAuthDTO userAuthDTO) {
        return userService.update(id, userAuthDTO);
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
