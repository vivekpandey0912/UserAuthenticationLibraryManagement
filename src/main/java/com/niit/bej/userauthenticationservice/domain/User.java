package com.niit.bej.userauthenticationservice.domain;


import lombok.*;

import javax.persistence.Entity;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Entity
public class User {

    private int emailId;
    private String password;
    private String userType;

}
