package com.niit.bej.userauthenticationservice.service;

import com.niit.bej.userauthenticationservice.domain.User;

public interface UserService {


    public User RegisterUser(User user);
    public User loginUser(User user);




}
