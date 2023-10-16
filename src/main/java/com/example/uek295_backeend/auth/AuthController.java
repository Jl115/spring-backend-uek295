package com.example.uek295_backeend.auth;

import com.example.uek295_backeend.user.UserAuthDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/auth/registration")
    public ResponseEntity<String> registration(@RequestBody RegistrationDTO registrationDTO) {
        authService.registration(registrationDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body("User registered successfully");
    }

    @PostMapping("/auth/login")
    public ResponseEntity<?> login(@RequestBody UserAuthDTO userAuthDTO) {
        String token = authService.authenticate(userAuthDTO.getName(), userAuthDTO.getPassword());
        if (token != null) {
            return ResponseEntity.ok(new AuthenticationResponse(token));
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
        }
    }
}

class AuthenticationResponse {
    private String jwt;

    public AuthenticationResponse(String jwt) {
        this.jwt = jwt;
    }

    public String getJwt() {
        return jwt;
    }
}