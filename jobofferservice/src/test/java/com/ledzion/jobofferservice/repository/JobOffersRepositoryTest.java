package com.ledzion.jobofferservice.repository;

import com.ledzion.jobofferservice.TestJobOffersCreator;
import com.ledzion.jobofferservice.model.JobOffer;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;
import java.util.List;

@DataMongoTest
@ExtendWith(SpringExtension.class)
class JobOffersRepositoryTest {

    private static final String JOB_OFFERS_COLLECTION = "job_offers";

    @Autowired
    private JobOffersRepository jobOffersRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    @BeforeEach
    public void init() {
        cleanDatabase();
    }

    @Test
    void findByCategory() {
    }

    @Test
    void findByEmployerName() {
        //given
        mongoTemplate.save(TestJobOffersCreator.getFirstTestJobOffer());
        mongoTemplate.save(TestJobOffersCreator.getSecondTestJobOffer());
        //when
        List<JobOffer> jobOffers = jobOffersRepository.findByCategory("IT");
        //then
        Assertions.assertThat(jobOffers.size()).isEqualTo(1);
        Assertions.assertThat(jobOffers.get(0).getId()).isEqualTo("1");
        Assertions.assertThat(jobOffers.get(0).getEmployerName()).isEqualTo("ABC Company");
        Assertions.assertThat(jobOffers.get(0).getStartDate()).isEqualTo(LocalDate.of(2021, 10, 11));
        Assertions.assertThat(jobOffers.get(0).getEndDate()).isEqualTo(LocalDate.of(2021, 11, 21));
    }

    private void cleanDatabase() {
        if(mongoTemplate.collectionExists(JOB_OFFERS_COLLECTION)) {
            mongoTemplate.dropCollection(JOB_OFFERS_COLLECTION);
        }
    }
}