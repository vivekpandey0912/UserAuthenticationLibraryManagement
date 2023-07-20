package com.niit.bej.userauthenticationservice.domain;


import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Entity
public class User {

    @Id
    private String emailId;
    private String password;
    private String userType;

}
