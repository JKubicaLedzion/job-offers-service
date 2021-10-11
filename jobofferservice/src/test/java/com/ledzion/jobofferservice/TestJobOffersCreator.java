package com.ledzion.jobofferservice;

import com.ledzion.jobofferservice.model.Category;
import com.ledzion.jobofferservice.model.JobOffer;
import com.ledzion.jobofferservice.model.JobOfferDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class TestJobOffersCreator {

    private static ObjectMapper objectMapper = new ObjectMapper()
            .registerModule(new JavaTimeModule()
                    .addDeserializer(LocalDate.class, new LocalDateDeserializer(DateTimeFormatter.ISO_DATE))
                    .addSerializer(LocalDate.class, new LocalDateSerializer(DateTimeFormatter.ISO_DATE)));

    public static JobOffer getFirstTestJobOffer() {
        JobOffer jobOffer = new JobOffer();
        jobOffer.setId("1");
        jobOffer.setCategory(Category.IT);
        jobOffer.setEmployerName("ABC Company");
        jobOffer.setStartDate(LocalDate.of(2021, 10, 11));
        jobOffer.setEndDate(LocalDate.of(2021, 11, 21));

        return jobOffer;
    }

    public static JobOffer getSecondTestJobOffer() {
        JobOffer jobOffer = new JobOffer();
        jobOffer.setId("2");
        jobOffer.setCategory(Category.OFFICE);
        jobOffer.setEmployerName("XYZ Company");
        jobOffer.setStartDate(LocalDate.of(2021, 10, 11));
        jobOffer.setEndDate(LocalDate.of(2021, 10, 21));

        return jobOffer;
    }

    public static JobOfferDto getFirstTestJobOfferDto() {
        JobOfferDto jobOffer = new JobOfferDto();
        jobOffer.setId("3");
        jobOffer.setCategory("IT");
        jobOffer.setEmployerName("ABC Company");
        jobOffer.setStartDate(LocalDate.of(2021, 10, 11));
        jobOffer.setEndDate(LocalDate.of(2021, 11, 21));

        return jobOffer;
    }

    public static JobOfferDto getSecondTestJobOfferDto() {
        JobOfferDto jobOffer = new JobOfferDto();
        jobOffer.setId("4");
        jobOffer.setCategory("OFFICE");
        jobOffer.setEmployerName("XYZ Company");
        jobOffer.setStartDate(LocalDate.of(2021, 10, 11));
        jobOffer.setEndDate(LocalDate.of(2021, 10, 21));

        return jobOffer;
    }

    public static String getFirstJobOfferDtoAsJson() throws JsonProcessingException {
        return objectMapper.writeValueAsString(new ArrayList<>() {{
            add(getFirstTestJobOfferDto());
        }});
    }
}
