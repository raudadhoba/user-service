package com.rd.user_service.services;

import com.rd.user_service.models.User;
import com.rd.user_service.repositary.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public boolean authenticateAdmin(String email, String password) {
        User user = userRepository.findByEmail(email);

        // If user found and password matches
        if (user != null && user.getPassword().equals(password)) {
            return true;
        }
        return false;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
