package com.niit.bej.userauthenticationservice.service;

import com.niit.bej.userauthenticationservice.domain.User;
import com.niit.bej.userauthenticationservice.exception.UserAlreadyExists;

public interface UserService {

    public User registerUser(User user) throws UserAlreadyExists;
//    public User loginUser(User user) throws UserNotFound, UserAlreadyExists;




}
