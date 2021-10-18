package com.ledzion.userservice.controller;

import com.ledzion.userservice.TestUsersCreator;
import com.ledzion.userservice.exceptions.UserNotFoundException;
import com.ledzion.userservice.repository.UserRepository;
import com.ledzion.userservice.service.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mapping.context.MappingContext;
import org.springframework.data.mongodb.core.convert.DbRefResolver;
import org.springframework.data.mongodb.core.convert.MappingMongoConverter;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static com.ledzion.userservice.TestUsersCreator.getFirstTestUser;
import static com.ledzion.userservice.TestUsersCreator.getFirstTestUserDto;
import static com.ledzion.userservice.TestUsersCreator.getFirstUserDtoAsJson;
import static org.mockito.Mockito.mock;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(UserController.class)
class UserControllerTest {

    //TODO: add tests checking all methods and possible results

    @Autowired
    private UserController userController;

    @MockBean
    private UserServiceImpl userService;

    @MockBean
    private UserDtoMapper userDtoMapper;

    @MockBean
    private UserRepository userRepository;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void addUserShouldSaveUser() throws Exception {
        //given
        Mockito.when(userDtoMapper.userDtoToUser(getFirstTestUserDto())).thenReturn(getFirstTestUser());
        //when
        mockMvc.perform(post("/users")
                .content(getFirstUserDtoAsJson())
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                //then
                .andExpect(status().isOk())
                .andExpect(content().string("User added."));
    }

    @Test
    void updateUser() {
    }

    @Test
    void deleteUser() {
    }

    @Test
    void getUserShouldReturnOkStatusAndUser() throws Exception {
        //given
        Mockito.when(userService.getUser("hr@abc.com")).thenReturn(getFirstTestUser());
        Mockito.when(userDtoMapper.userToUserDto(getFirstTestUser())).thenReturn(getFirstTestUserDto());
        //when
        mockMvc.perform(get("/users/hr@abc.com")
                .accept(MediaType.ALL))
                .andDo(print())
                //then
                .andExpect(status().isOk())
                .andExpect(content().string(TestUsersCreator.getFirstUserDtoAsJson()));
    }

    @Test
    void getUserShouldReturnNotFoundStatus() throws Exception {
        //given
        Mockito.when(userService.getUser("hr@abc.com")).thenThrow(new UserNotFoundException("User not found."));
        //when
        mockMvc.perform(get("/users/hr@abc.com")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                //then
                .andExpect(status().isNotFound());
    }

    @Test
    void getUsers() {
    }

    @TestConfiguration
    static class TestConfig {

        @Bean
        public MappingMongoConverter mongoConverter() {
            return new MappingMongoConverter(mock(DbRefResolver.class), mock(MappingContext.class));
        }
    }
}