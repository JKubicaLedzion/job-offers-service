package com.ledzion.userservice.model;

import lombok.Data;
import lombok.ToString;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Data
@Document(collection = "users")
@ToString(exclude = "password")
public class User {

    @Id
    private String login;

    private String password;

    private String name;

    //TODO: fix problem with creation of date
    @CreatedDate
    private LocalDate creationDate;
}
