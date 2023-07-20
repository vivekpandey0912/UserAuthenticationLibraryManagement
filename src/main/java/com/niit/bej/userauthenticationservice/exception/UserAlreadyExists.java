package com.niit.bej.userauthenticationservice.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT, reason = "User Already Exist in the Database")
public class UserAlreadyExists extends Exception{

    public UserAlreadyExists(String message) {
        super(message);
    }
}
