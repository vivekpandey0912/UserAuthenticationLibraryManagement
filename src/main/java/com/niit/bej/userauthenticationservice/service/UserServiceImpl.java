package com.niit.bej.userauthenticationservice.service;

import com.niit.bej.userauthenticationservice.domain.User;
import com.niit.bej.userauthenticationservice.exception.UserAlreadyExists;
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
    public User RegisterUser(User user) throws UserAlreadyExists {
         if(userRepository.findUserByEmailId(user.getEmailId()))
        {
            throw new UserAlreadyExists("User Already Exists in the Database");
        }else
         {
             return userRepository.save(user);
         }
    }

    @Override
    public User loginUser(User user) throws UserAlreadyExists {
        User user1 = userRepository.findUserByEmailIdAndPasswordAndUserType(user.getEmailId(),user.getPassword(),user.getUserType());
        if (user1 != null) {

            if(user1.getUserType().equals("normal"))
            {
                System.out.println("Normal User = " + user1.getUserType());
                return user1;
            }
            else if(user1.getUserType().equals("admin"))
            {
                System.out.println("Admin User = " + user1.getUserType());
                return user1;
            }
        }
            throw new UserAlreadyExists("User Already Exist");


    }
}
