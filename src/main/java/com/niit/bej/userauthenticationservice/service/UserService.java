package com.niit.bej.userauthenticationservice.service;

import com.niit.bej.userauthenticationservice.domain.User;
import com.niit.bej.userauthenticationservice.exception.UserAlreadyExists;
import com.niit.bej.userauthenticationservice.exception.UserNotFound;

public interface UserService {


    public User RegisterUser(User user) throws UserAlreadyExists;
    public User loginUser(User user) throws UserNotFound, UserAlreadyExists;




}
