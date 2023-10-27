package com.example.uek295_backeend.auth;

import com.example.uek295_backeend.user.User;
import com.example.uek295_backeend.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

/**
 * Service for authentication-related operations.
 * It provides methods for user registration and JWT retrieval for authenticated users.
 */
@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private JwtService jwtService;

    // Password encoder for hashing user passwords.
    private final BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    /**
     * Registers a new user by saving their details to the database.
     * The user's password is hashed before being stored.
     *
     * @param registrationDto The user registration details.
     */
    public void register(RegistrationDTO registrationDto) {
        User user = new User();
        user.setName(registrationDto.getName());
        user.setPassword(bCryptPasswordEncoder.encode(registrationDto.getPassword()));
        userRepository.save(user);
    }

    /**
     * Authenticates a user based on their login details and returns a JWT.
     * Throws an exception if authentication fails.
     *
     * @param loginDto The user login details.
     * @return A JWT for the authenticated user.
     */
    public String getJwt(LoginDTO loginDto) {
        User user = userRepository.findByName(loginDto.getUserName())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.UNAUTHORIZED));
        if (!bCryptPasswordEncoder.matches(loginDto.getPassword(), user.getPassword())) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
        }
        return jwtService.createJwt(user.getName());
    }
}
