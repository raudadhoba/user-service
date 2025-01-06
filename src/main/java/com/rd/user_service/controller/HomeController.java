package com.rd.user_service.controller;

import com.rd.user_service.models.User;
import com.rd.user_service.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class HomeController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public String login(@RequestBody User loginRequest) {
        boolean isAuthenticated = userService.authenticateAdmin(loginRequest.getEmail(), loginRequest.getPassword());
        if (isAuthenticated) {
            return "success";  // Successful login
        } else {
            return "fail";  // Failed login
        }
    }


    @GetMapping("/")
    public ResponseEntity<?> getAllUsers(){
        List<User> users = userService.getAllUsers();

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(users);
    }
}
