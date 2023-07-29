package com.niit.bej.userauthenticationservice.controller;


import com.niit.bej.userauthenticationservice.domain.User;
import com.niit.bej.userauthenticationservice.exception.UserAlreadyExists;
import com.niit.bej.userauthenticationservice.exception.UserNotFound;
import com.niit.bej.userauthenticationservice.security.SecurityTokenGenerator;
import com.niit.bej.userauthenticationservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;


@RestController
@RequestMapping("/authUser")
public class UserController {


    private final UserService userService;
    private final SecurityTokenGenerator securityTokenGenerator;

    @Autowired
    public UserController(UserService userService, SecurityTokenGenerator securityTokenGenerator) {
        this.userService = userService;
        this.securityTokenGenerator = securityTokenGenerator;
    }

    @PostMapping("/registerUser")
    public ResponseEntity<?> registerUser(@RequestBody User user) {
        try {
            return new ResponseEntity<>(userService.registerUser(user), HttpStatus.CREATED);
        } catch (UserAlreadyExists e) {
            return new ResponseEntity<>("User Already Exist", HttpStatus.CONFLICT);
        }

    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody User user) {
        try {
            User user1 = userService.loginUser(user);
            Map<String, String> token = securityTokenGenerator.generateToken(user);
            return new ResponseEntity<>(token, HttpStatus.OK);
        } catch (UserNotFound e) {
            return new ResponseEntity<>("User Not Found", HttpStatus.CONFLICT);
        }


    }
    @PostMapping("/adminlogin")
    public ResponseEntity<?> loginUserAdmin(@RequestBody User user) {
        try {
            User user1 = userService.loginUserAdmin(user);
            Map<String, String> token = securityTokenGenerator.generateToken(user);
            return new ResponseEntity<>(token, HttpStatus.OK);
        } catch (UserNotFound e) {
            return new ResponseEntity<>("User Not Found", HttpStatus.NOT_FOUND);
        }


    }


}