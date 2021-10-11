package com.ledzion.userservice.service;

import com.ledzion.userservice.exceptions.UserNotFoundException;
import com.ledzion.userservice.model.User;
import com.ledzion.userservice.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Override
    public void addUser(User user) {
        //TODO: validate user details and in case user details do not meet requirements throw exception
        // InvalidUserDetailsException
        userRepository.save(user);
    }

    @Override
    public void updateUser(User user) {
        //TODO: validate user details and in case user details do not meet requirements throw exception
        // InvalidUserDetailsException
        userRepository.save(user);
        //TODO: in case of update of user name call UpdateUserNameProducer to send a message to a queue allowing to
        // job offers service read message and update offers with updated name
    }

    @Override
    public void deleteUser(String login) {
        userRepository.deleteByLogin(login);
    }

    @Override
    public User getUser(String login) {
        //TODO: optional to be returned by repository
        return Optional.ofNullable(userRepository.findByLogin(login))
                .orElseThrow(() -> new UserNotFoundException("User not found."));
    }

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }
}
