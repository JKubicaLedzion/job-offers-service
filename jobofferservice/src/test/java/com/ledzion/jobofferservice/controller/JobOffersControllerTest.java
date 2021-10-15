package com.ledzion.jobofferservice.controller;

import com.ledzion.jobofferservice.TestJobOffersCreator;
import com.ledzion.jobofferservice.repository.JobOffersRepository;
import com.ledzion.jobofferservice.service.JobOffersServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(JobOffersController.class)
class JobOffersControllerTest {

    //TODO: add tests checking all methods and possible results

    @Autowired
    private JobOffersController jobOffersController;

    @MockBean
    private JobOffersServiceImpl jobOffersService;

    @MockBean
    private JobOfferDtoMapper jobOfferDtoMapper;

    @MockBean
    private JobOffersRepository jobOffersRepository;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void addJobOffer() {
    }

    @Test
    void getJobOffersShouldReturnOkStatusAndJobOffer() throws Exception {
        //given
        Mockito.when(jobOffersService.getJobOffers("IT", null)).thenReturn(new ArrayList<>() {{
            add(TestJobOffersCreator.getFirstTestJobOffer());
        }});
        Mockito.when(jobOfferDtoMapper.jobOfferToJobOfferDto(TestJobOffersCreator.getFirstTestJobOffer())).thenReturn(TestJobOffersCreator.getFirstTestJobOfferDto());
        //when
        mockMvc.perform(get("/joboffers?category=IT")
                .accept(MediaType.ALL))
                .andDo(print())
                //then
                .andExpect(status().isOk())
                .andExpect(content().string(TestJobOffersCreator.getFirstJobOfferDtoAsJson()));
    }
}