package com.niit.bej.userauthenticationservice.service;

import com.niit.bej.userauthenticationservice.domain.User;
import com.niit.bej.userauthenticationservice.exception.UserAlreadyExists;
import com.niit.bej.userauthenticationservice.exception.UserNotFound;
import com.niit.bej.userauthenticationservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User registerUser(User user) throws UserAlreadyExists {
         if(userRepository.findById(user.getEmailId()).isPresent())
        {
            throw new UserAlreadyExists("User Already Exists in the Database");
        }else
         {
             user.setUserType("normal");
             return userRepository.save(user);
         }
    }

    @Override
    public User loginUser(User user) throws UserNotFound {
        User user1 = userRepository.findUserByEmailIdAndPasswordAndUserType(user.getEmailId(),user.getPassword(),"normal");
        if (user1 != null) {
                System.out.println("Normal User = " + user1.getUserType());
                return user1;
            }

        else {
            throw new UserNotFound("User Not Found");
        }

    }
}
