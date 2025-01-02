package com.rd.user_service.controller;

import com.rd.user_service.models.User;
import com.rd.user_service.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
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
}
