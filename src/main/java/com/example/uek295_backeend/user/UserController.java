package com.example.uek295_backeend.user;

import org.springframework.beans.factory.annotation.Autowired;
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
    @PreAuthorize("#id == authentication.principal.id or hasRole('ADMIN')")
    public ResponseEntity<UserDTO> getUserById(@PathVariable Long id) {
        return ResponseEntity.ok(userService.getById(id));
    }

    // GET Mapping to get all users
    @GetMapping("/user")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<List<UserDTO>> getAllUsers() {
        return ResponseEntity.ok(userService.getAll());
    }

    // POST Mapping to create a new user
    @PostMapping("/user")
    public ResponseEntity<UserAuthDTO> createUser(@RequestBody UserAuthDTO userAuthDTO) {
        return ResponseEntity.status(201).body(userService.create(userAuthDTO));
    }

    // PUT Mapping to update a user
    @PutMapping("/user/{id}")
    @PreAuthorize("#id == authentication.principal.id or hasRole('ADMIN')")
    public ResponseEntity<UserDTO> updateUser(@PathVariable Long id, @RequestBody UserDTO userDTO) {
        return ResponseEntity.ok(userService.update(id, userDTO));
    }

    // POST Mapping to promote user to admin
    @PostMapping("/user/promote/{userId}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> promoteToAdmin(@PathVariable int userId) {
        userService.promoteToAdmin(userId);
        return ResponseEntity.ok("User promoted to admin successfully");
    }

    @PutMapping("/user/{id}/admin")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<UserAuthDTO> updateToAdmin(@PathVariable Long id, @RequestBody UserAuthDTO userAuthDTO) {
        return ResponseEntity.ok(userService.update(id, userAuthDTO));
    }

    // DELETE Mapping to delete a user by ID
    @DeleteMapping("/user/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleExceptions(Exception ex) {
        return ResponseEntity.status(500).body(ex.getMessage());
    }
}

