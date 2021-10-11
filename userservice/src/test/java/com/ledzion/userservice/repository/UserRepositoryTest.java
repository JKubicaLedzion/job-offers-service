package com.ledzion.userservice.repository;

import com.ledzion.userservice.model.User;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;

import static com.ledzion.userservice.TestUsersCreator.*;

@DataMongoTest
@ExtendWith(SpringExtension.class)
class UserRepositoryTest {

    private static final String USERS_COLLECTION = "users";

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    @BeforeEach
    public void init() {
        cleanDatabase();
    }

    @Test
    void deleteByLoginShouldDeleteUser() {
        //given
        mongoTemplate.save(getFirstTestUser());
        mongoTemplate.save(getSecondTestUser());
        //when
        userRepository.deleteByLogin("hr@xyz.com");
        //then
        Assertions.assertThat(mongoTemplate.findById("hr@xyz.com", User.class)).isNull();
        Assertions.assertThat(mongoTemplate.findAll(User.class, USERS_COLLECTION).size()).isEqualTo(1);
    }

    @Test
    void findByLoginShouldReturnUser() {
        //given
        mongoTemplate.save(getFirstTestUser());
        mongoTemplate.save(getSecondTestUser());
        //when
        User user = userRepository.findByLogin("hr@abc.com");
        //then
        Assertions.assertThat(user.getLogin()).isEqualTo("hr@abc.com");
        Assertions.assertThat(user.getPassword()).isEqualTo("345%6fjifhewjkd");
        Assertions.assertThat(user.getName()).isEqualTo("ABC Company");
        Assertions.assertThat(user.getCreationDate()).isEqualTo(LocalDate.of(2021, 10, 11));
    }

    private void cleanDatabase() {
        if(mongoTemplate.collectionExists(USERS_COLLECTION)) {
            mongoTemplate.dropCollection(USERS_COLLECTION);
        }
    }
}