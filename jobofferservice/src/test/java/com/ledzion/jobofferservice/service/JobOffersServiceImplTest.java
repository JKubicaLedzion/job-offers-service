package com.ledzion.jobofferservice.service;

import com.ledzion.jobofferservice.TestJobOffersCreator;
import com.ledzion.jobofferservice.model.JobOffer;
import com.ledzion.jobofferservice.repository.JobOffersRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class JobOffersServiceImplTest {

    //TODO: add tests checking all methods and possible results

    @InjectMocks
    private JobOffersServiceImpl jobOffersService;

    @Mock
    private JobOffersRepository jobOffersRepository;

    @Captor
    private ArgumentCaptor<JobOffer> jobOfferCaptor;

    @Test
    void addJobOfferShouldAddJobOffer() {
        //given
        JobOffer jobOffer = TestJobOffersCreator.getFirstTestJobOffer();
        //when
        jobOffersService.addJobOffer(jobOffer);
        //then
        Mockito.verify(jobOffersRepository).save(jobOfferCaptor.capture());
        Assertions.assertThat(jobOfferCaptor.getValue()).isEqualTo(jobOffer);
    }

    @Test
    void getJobOffers() {
    }
}