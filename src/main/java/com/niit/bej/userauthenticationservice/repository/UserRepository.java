package com.niit.bej.userauthenticationservice.repository;

import com.niit.bej.userauthenticationservice.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository <User,String> {

    User findUserByEmailIdAndPasswordAndUserType(String emailId, String password, String userType);
    boolean findUserByEmailId(String emailId);

}
