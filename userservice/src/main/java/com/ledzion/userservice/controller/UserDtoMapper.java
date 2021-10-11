package com.ledzion.userservice.controller;

import com.ledzion.userservice.model.User;
import com.ledzion.userservice.model.UserDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserDtoMapper {

    UserDto userToUserDto(User user);

    User userDtoToUser(UserDto userDto);
}
