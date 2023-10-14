/*
package com.example.uek295_backeend.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/api")
public class AuthController {
    @Autowired
    private AuthService authService;
    @PostMapping("/auth/registration")
    public ResponseEntity<String> registration(@RequestBody RegistrationDTO registrationDTO) {
        authService.registration(registrationDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body("User registered successfully");
    }
}


 */