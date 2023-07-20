package com.niit.bej.userauthenticationservice.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "User Not Found Exception")
public class UserNotFound extends Exception {
    public UserNotFound(String message) {
        super(message);
    }
}
