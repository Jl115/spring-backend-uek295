package com.example.uek295_backeend.auth;

import com.example.uek295_backeend.user.User;
import com.example.uek295_backeend.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
@Service
public class AuthService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtUtil jwtUtil;
    private BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
    public void registration(RegistrationDTO registrationDTO) {
        User user = new User();
        user.setName(registrationDTO.getName());
        user.setPassword(bCryptPasswordEncoder.encode(registrationDTO.getPassword()));
        userRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByName(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return new org.springframework.security.core.userdetails.User(user.getName(), user.getPassword(), new ArrayList<>());
    }

    public String authenticate(String username, String password) {
        User user = userRepository.findByName(username);
        if (user != null && bCryptPasswordEncoder.matches(password, user.getPassword())) {
            return jwtUtil.generateToken(user);
        }
        return null;
    }
}
