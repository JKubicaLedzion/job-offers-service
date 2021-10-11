package com.ledzion.userservice.model;

import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@ToString(exclude = "password")
public class UserDto {

    //TODO: add validation that login is required and unique
    private String login;

    //TODO: add validation that password fulfills requirements (i.e. password should contains special characters and numbers,
    // both uppercase and lowercase letters)
    //TODO: password should not be stored in database without protection (i.e. encryption)
    //TODO: for managing users(login and password only)/authorization/authentication external provider can be used (i.e. Okta, Keycloak)
    private String password;

    //TODO: add validation that is required and unique
    private String name;

    //TODO: field should not be visible in case of adding user or
    // separate class for adding a or separate class should be created for add/update user and get user
    private LocalDate creationDate;
}
