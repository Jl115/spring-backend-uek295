package com.example.uek295_backeend.auth;

import com.example.uek295_backeend.user.UserAuthDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller for authentication-related operations such as user registration and login.
 * This controller handles endpoints under the "/api" base path.
 */
@RestController
@RequestMapping("/api")
public class AuthController {

    @Autowired
    private AuthService authService;

    /**
     * Registers a new user.
     *
     * @param registrationDTO The user registration details.
     * @return A response indicating the success of the registration.
     */
    @PostMapping("/auth/registration")
    public ResponseEntity<String> registration(@RequestBody RegistrationDTO registrationDTO) {
        authService.register(registrationDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body("User registered successfully");
    }

    /**
     * Authenticates a user and provides a JWT for subsequent authenticated requests.
     *
     * @param loginDto The user login details.
     * @return A JWT if the authentication is successful.
     */
    @PostMapping("/auth/login")
    public ResponseEntity<String> login(@RequestBody LoginDTO loginDto) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(authService.getJwt(loginDto));
    }
}
