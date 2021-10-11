package com.ledzion.jobofferservice.repository;

import com.ledzion.jobofferservice.model.JobOffer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobOffersRepository extends MongoRepository<JobOffer, String> {

    //TODO: add pagination for getting job offers

    //TODO: add a functionality to get only valid job offers

    //TODO: replace below methods with one
    List<JobOffer> findByCategory(String category);

    List<JobOffer> findByEmployerName(String employerName);

    List<JobOffer> findByCategoryAndEmployerName(String category, String employerName);
}
