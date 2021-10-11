package com.ledzion.jobofferservice.controller;

import com.ledzion.jobofferservice.model.JobOfferDto;
import com.ledzion.jobofferservice.service.JobOffersService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequestMapping("/joboffers")
@AllArgsConstructor
public class JobOffersController {

    //TODO: extract hardcoded Strings to constants

    private JobOffersService jobOffersService;

    private JobOfferDtoMapper jobOfferDtoMapper;

    @PostMapping
    public ResponseEntity<String> addJobOffer(@RequestBody JobOfferDto jobOfferDto) {
        log.info("Adding job offer: {}.", jobOfferDto);
        jobOffersService.addJobOffer(jobOfferDtoMapper.jobOfferDtoToJobOffer(jobOfferDto));
        return ResponseEntity.ok("Job offer added.");
    }

    @GetMapping
    public ResponseEntity<List<JobOfferDto>> getJobOffers(@RequestParam(required=false) String category,
                                                          @RequestParam(required=false) String employerName) {
        log.info("Getting job offers.");
        return ResponseEntity.ok(jobOffersService.getJobOffers(category, employerName).stream()
                .map(jobOffer -> jobOfferDtoMapper.jobOfferToJobOfferDto(jobOffer))
                .collect(Collectors.toList()));
    }
}
