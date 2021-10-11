package com.ledzion.userservice.controller;

import com.ledzion.userservice.model.UserDto;
import com.ledzion.userservice.service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserController {

    //TODO: extract hardcoded Strings to constants

    private UserService userService;

    private UserDtoMapper userDtoMapper;

    @PostMapping
    public ResponseEntity<String> addUser(@RequestBody UserDto userDto) {
        log.info("Adding user: {}.", userDto);
        userService.addUser(userDtoMapper.userDtoToUser(userDto));
        return ResponseEntity.ok("User added.");
    }

    @PutMapping("/{login}")
    public ResponseEntity<String> updateUser(@RequestBody UserDto userDto) {
        log.info("Updating user: {}.", userDto);
        userService.updateUser(userDtoMapper.userDtoToUser(userDto));
        return ResponseEntity.ok("User updated.");
    }

    @DeleteMapping("/{login}")
    public ResponseEntity<String> deleteUser(@PathVariable("login") String login) {
        log.info("Deleting user: {}.", login);
        userService.deleteUser(login);
        return ResponseEntity.ok("User deleted.");
    }

    @GetMapping("/{login}")
    public ResponseEntity<UserDto> getUser(@PathVariable("login") String login) {
        log.info("Getting details of user: {}.", login);
        return ResponseEntity.ok(userDtoMapper.userToUserDto(userService.getUser(login)));
    }

    @GetMapping
    public ResponseEntity<List<UserDto>> getUsers() {
        log.info("Getting all users.");
        return ResponseEntity.ok(userService.getUsers().stream()
                .map(user -> userDtoMapper.userToUserDto(user))
                .collect(Collectors.toList()));
    }
}
