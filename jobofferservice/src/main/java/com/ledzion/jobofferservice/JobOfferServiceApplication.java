package com.ledzion.jobofferservice;

import com.ledzion.jobofferservice.repository.JobOffersRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableMongoRepositories(basePackageClasses = {JobOffersRepository.class})
@SpringBootApplication
public class JobOfferServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(JobOfferServiceApplication.class, args);
	}

}
