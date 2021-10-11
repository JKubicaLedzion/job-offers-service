package com.ledzion.jobofferservice.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Data
@Document(collection = "job_offers")
public class JobOffer {

    @Id
    private String id;

    private Category category;

    private LocalDate startDate;

    private LocalDate endDate;

    private String employerName;
}
