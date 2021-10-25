package com.ledzion.userservice.controller;

import com.ledzion.userservice.model.User;
import com.ledzion.userservice.model.UserDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserDtoMapper {

    UserDto userToUserDto(User user);

    User userDtoToUser(UserDto userDto);
}
