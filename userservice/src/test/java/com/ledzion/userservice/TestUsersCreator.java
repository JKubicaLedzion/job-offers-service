package com.ledzion.userservice;

import com.ledzion.userservice.model.User;
import com.ledzion.userservice.model.UserDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class TestUsersCreator {

    private static ObjectMapper objectMapper = new ObjectMapper()
            .registerModule(new JavaTimeModule()
                    .addDeserializer(LocalDate.class, new LocalDateDeserializer(DateTimeFormatter.ISO_DATE))
                    .addSerializer(LocalDate.class, new LocalDateSerializer(DateTimeFormatter.ISO_DATE)));

    public static User getFirstTestUser() {
        User user = new User();
        user.setLogin("hr@abc.com");
        user.setPassword("345%6fjifhewjkd");
        user.setName("ABC Company");
        user.setCreationDate(LocalDate.now());

        return user;
    }

    public static User getSecondTestUser() {
        User user = new User();
        user.setLogin("hr@xyz.com");
        user.setPassword("gtsdwew%$12");
        user.setName("XYZ Company");
        user.setCreationDate(LocalDate.now());

        return user;
    }

    public static UserDto getFirstTestUserDto() {
        UserDto user = new UserDto();
        user.setLogin("hr@abc.com");
        user.setPassword("345%6fjifhewjkd");
        user.setName("ABC Company");
        user.setCreationDate(LocalDate.now());

        return user;
    }

    public static UserDto getSecondTestUserDto() {
        UserDto user = new UserDto();
        user.setLogin("hr@xyz.com");
        user.setPassword("gtsdwew%$12");
        user.setName("XYZ Company");
        user.setCreationDate(LocalDate.now());

        return user;
    }

    public static String getFirstUserDtoAsJson() throws JsonProcessingException {
        return objectMapper.writeValueAsString(getFirstTestUserDto());
    }
}
