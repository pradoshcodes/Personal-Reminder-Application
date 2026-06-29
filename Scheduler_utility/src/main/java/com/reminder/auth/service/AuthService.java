package com.reminder.auth.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.reminder.auth.dto.LoginRequest;
import com.reminder.auth.dto.RegisterRequest;
import com.reminder.auth.entity.User;
import com.reminder.auth.repository.UserRepository;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public String register(RegisterRequest request) {

        if (userRepository.findByEmail(request.getEmail()).isPresent()) {
            return "Email already exists";
        }

        User user = new User();
        user.setFullName(request.getFullName());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setStatus("1");

        userRepository.save(user);

        return "User registered successfully";
    }
    
    public String login(LoginRequest request) {

        Optional<User> optionalUser =
                userRepository.findByEmail(request.getEmail());

        if(optionalUser.isEmpty()) {
            return "Invalid Email";
        }

        User user = optionalUser.get();

        boolean match =
                passwordEncoder.matches(
                        request.getPassword(),
                        user.getPassword());

        if(!match) {
            return "Invalid Password";
        }

        return "Login Successfully";
    }
}