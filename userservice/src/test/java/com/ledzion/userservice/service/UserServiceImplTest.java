package com.ledzion.userservice.service;

import com.ledzion.userservice.model.User;
import com.ledzion.userservice.repository.UserRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static com.ledzion.userservice.TestUsersCreator.getFirstTestUser;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {

    //TODO: add tests checking all methods and possible results

    @InjectMocks
    private UserServiceImpl userService;

    @Mock
    private UserRepository userRepository;

    @Captor
    private ArgumentCaptor<User> userCapture;

    @Captor
    private ArgumentCaptor<String> loginCapture;

    @Test
    void addUserShouldAddUser() {
        //given
        User user = getFirstTestUser();
        //when
        userService.addUser(user);
        //then
        Mockito.verify(userRepository).save(userCapture.capture());
        Assertions.assertThat(userCapture.getValue()).isEqualTo(user);
    }

    @Test
    void updateUser() {
    }

    @Test
    void deleteUser() {
    }

    @Test
    void getUserShouldReturnUser() {
        //given
        Mockito.when(userRepository.findByLogin("hr@abc.com")).thenReturn(getFirstTestUser());
        //when
        User resultUser = userService.getUser("hr@abc.com");
        //then
        Mockito.verify(userRepository).findByLogin(loginCapture.capture());
        Assertions.assertThat(loginCapture.getValue()).isEqualTo("hr@abc.com");

        Assertions.assertThat(resultUser.getLogin()).isEqualTo("hr@abc.com");
        Assertions.assertThat(resultUser.getPassword()).isEqualTo("345%6fjifhewjkd");
        Assertions.assertThat(resultUser.getName()).isEqualTo("ABC Company");
        Assertions.assertThat(resultUser.getCreationDate()).isEqualTo(LocalDate.now());
    }

    @Test
    void getUsers() {
    }
}