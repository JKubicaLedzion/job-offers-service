package com.ledzion.jobofferservice.service;

import com.ledzion.jobofferservice.model.JobOffer;

import java.util.List;

public interface JobOffersService {

    void addJobOffer(JobOffer jobOffer);

    List<JobOffer> getJobOffers(String category, String employerName);
}
