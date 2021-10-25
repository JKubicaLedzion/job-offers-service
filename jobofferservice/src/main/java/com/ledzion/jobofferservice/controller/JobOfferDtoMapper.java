package com.ledzion.jobofferservice.controller;

import com.ledzion.jobofferservice.model.JobOffer;
import com.ledzion.jobofferservice.model.JobOfferDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface JobOfferDtoMapper {

    //TODO: mapping of enum to be corrected

    JobOfferDto jobOfferToJobOfferDto(JobOffer jobOffer);

    JobOffer jobOfferDtoToJobOffer(JobOfferDto jobOfferDto);
}
