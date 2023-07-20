package com.niit.bej.userauthenticationservice.repository;

import com.fasterxml.jackson.databind.introspect.AnnotationCollector;
import com.niit.bej.userauthenticationservice.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository <User,String> {

    User findUserByEmailIdAndPasswordAndUserType(String emailId, String password, String userType);
    boolean findUserByEmailId(String emailId);

}
