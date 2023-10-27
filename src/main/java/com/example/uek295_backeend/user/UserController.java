package com.example.uek295_backeend.user;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller responsible for user management.
 */
@RestController
@RequestMapping("/api")
@Tag(name = "Users", description = "API for User Management")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * Retrieves a specific user by ID.
     *
     * @param id The ID of the user to retrieve.
     * @return The user DTO.
     */
    @GetMapping("/user/{id}")
    @PreAuthorize(" hasRole('ADMIN')")
    @Operation(summary = "Get user by ID", security = @SecurityRequirement(name = "bearerAuth"))
    public ResponseEntity<UserDTO> getUserById(@PathVariable Long id) {
        return ResponseEntity.ok(userService.getById(id));
    }

    /**
     * Retrieves all users.
     *
     * @return List of user DTOs.
     */
    @GetMapping("/user")
    @PreAuthorize("hasRole('ADMIN')")
    @Operation(summary = "Get all users", security = @SecurityRequirement(name = "bearerAuth"))
    public ResponseEntity<List<UserDTO>> getAllUsers() {
        return ResponseEntity.ok(userService.getAll());
    }

    /**
     * Creates a new user.
     *
     * @param userAuthDTO The user details.
     * @return The created user's auth DTO.
     */
    @PostMapping("/user")
    @Operation(summary = "Create a new user")
    public ResponseEntity<UserAuthDTO> createUser(@RequestBody UserAuthDTO userAuthDTO) {
        return ResponseEntity.status(201).body(userService.create(userAuthDTO));
    }

    /**
     * Updates a specific user.
     *
     * @param id The ID of the user to update.
     * @param userDTO The updated user details.
     * @return The updated user DTO.
     */
    @PutMapping("/user/{id}")
    @PreAuthorize("#id == authentication.principal.id or hasRole('ADMIN')")
    @Operation(summary = "Update user", security = @SecurityRequirement(name = "bearerAuth"))
    public ResponseEntity<UserDTO> updateUser(@PathVariable Long id, @RequestBody UserDTO userDTO) {
        return ResponseEntity.ok(userService.update(id, userDTO));
    }

    /**
     * Promotes a user to admin.
     *
     * @param userId The ID of the user to promote.
     * @return Response indicating the promotion status.
     */
    @PostMapping("/user/promote/{userId}")
    @PreAuthorize("hasRole('ADMIN')")
    @Operation(summary = "Promote user to admin", security = @SecurityRequirement(name = "bearerAuth"))
    public ResponseEntity<String> promoteToAdmin(@PathVariable int userId) {
        userService.promoteToAdmin(userId);
        return ResponseEntity.ok("User promoted to admin successfully");
    }

    /**
     * Updates a user to admin role.
     *
     * @param id The ID of the user to update.
     * @param userAuthDTO The updated user details.
     * @return The updated user's auth DTO.
     */
    @PutMapping("/user/{id}/admin")
    @PreAuthorize("hasRole('ADMIN')")
    @Operation(summary = "Update user to admin role", security = @SecurityRequirement(name = "bearerAuth"))
    public ResponseEntity<UserAuthDTO> updateToAdmin(@PathVariable Long id, @RequestBody UserAuthDTO userAuthDTO) {
        return ResponseEntity.ok(userService.update(id, userAuthDTO));
    }

    /**
     * Deletes a user by ID.
     *
     * @param id The ID of the user to delete.
     * @return Response indicating the deletion status.
     */
    @DeleteMapping("/user/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    @Operation(summary = "Delete user by ID", security = @SecurityRequirement(name = "bearerAuth"))
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.delete(id);
        return ResponseEntity.noContent().build();
    }

    /**
     * Exception handler for the controller.
     *
     * @param ex The exception thrown.
     * @return The error response.
     */
    @ExceptionHandler(Exception.class)
    @ApiResponses(value = {
            @ApiResponse(responseCode = "500", description = "Internal Server Error")
    })
    public ResponseEntity<String> handleExceptions(Exception ex) {
        return ResponseEntity.status(500).body(ex.getMessage());
    }
}
