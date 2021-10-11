package com.ledzion.userservice.repository;

import com.ledzion.userservice.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

    void deleteByLogin(String login);

    //TODO: optional to be returned
    User findByLogin(String login);
}
