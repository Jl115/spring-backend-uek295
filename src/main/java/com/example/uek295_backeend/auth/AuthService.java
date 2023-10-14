/*
package com.example.uek295_backeend.auth;

import com.example.uek295_backeend.user.User;
import com.example.uek295_backeend.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
    public void registration(RegistrationDTO registrationDTO) {
        User user = new User();
        user.setName(registrationDTO.getName());
        user.setPassword(bCryptPasswordEncoder.encode(registrationDTO.getPassword()));
        userRepository.save(user);
    }
}
*/