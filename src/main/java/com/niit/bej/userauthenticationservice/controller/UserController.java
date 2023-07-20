package com.niit.bej.userauthenticationservice.controller;


import com.niit.bej.userauthenticationservice.domain.User;
import com.niit.bej.userauthenticationservice.exception.UserAlreadyExists;
import com.niit.bej.userauthenticationservice.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RequestMapping("authUser")
@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("registerUser")
    public ResponseEntity<?> registerUser(User user)
    {
        try {
            return new ResponseEntity<>(userService.registerUser(user), HttpStatus.OK);
        } catch (UserAlreadyExists e) {
            return new ResponseEntity<>("User Already Exist", HttpStatus.CONFLICT);
        }

    }






}
