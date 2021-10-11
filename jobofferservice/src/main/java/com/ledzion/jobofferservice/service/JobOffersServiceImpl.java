package com.ledzion.jobofferservice.service;

import com.ledzion.jobofferservice.model.JobOffer;
import com.ledzion.jobofferservice.repository.JobOffersRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@AllArgsConstructor
public class JobOffersServiceImpl implements JobOffersService {

    private JobOffersRepository jobOffersRepository;

    @Override
    public void addJobOffer(JobOffer jobOffer) {
        //TODO: validate job offer details and in case job offer details do not meet requirements throw exception
        // InvalidJobOfferDetailsException
        jobOffersRepository.save(jobOffer);
    }

    @Override
    public List<JobOffer> getJobOffers(String category, String employerName) {
        //TODO: to be replaced by calling one method from job offer repository
        return Objects.nonNull(category)
                ? (Objects.nonNull(employerName)
                    ? jobOffersRepository.findByCategoryAndEmployerName(category, employerName)
                    : jobOffersRepository.findByCategory(category))
                : (Objects.nonNull(employerName)
                    ? jobOffersRepository.findByEmployerName(employerName)
                    : jobOffersRepository.findAll());
    }
}
