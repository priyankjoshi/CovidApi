package com.cs.covidapi.service.impl;

import com.cs.covidapi.converter.CovidDetailsConverter;
import com.cs.covidapi.dto.CovidResponse;
import com.cs.covidapi.exception.DataNotFoundException;
import com.cs.covidapi.model.CovidDetails;
import com.cs.covidapi.repository.CovidRepository;
import com.cs.covidapi.service.CovidService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class CovidServiceImpl implements CovidService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CovidServiceImpl.class);

    @Autowired
    private CovidDetailsConverter converter;

    private CovidRepository covidRepository;

    private CovidServiceImpl(CovidRepository covidRepository){
        this.covidRepository = covidRepository;
    }

    @Override
    public CovidResponse getCovidDetailsByCountryName(String country) throws DataNotFoundException{
       List<CovidDetails> covidDetailsList= covidRepository.findByCountry(country);
       if(covidDetailsList.isEmpty()) {
           LOGGER.debug("No data found for country {}", country);
           throw new DataNotFoundException("No Data for the country " + country + " found !!!");
       }
       return converter.convertCovidDetails(covidDetailsList).get();
    }

    @Override
    public List<CovidResponse> getCovidDetailsByDateFilter(LocalDate date) throws DataNotFoundException {
        List<CovidDetails> covidDetails = covidRepository.findByLastUpdate(date);

        if(covidDetails.isEmpty()) {
            LOGGER.debug("No data found for date {}", date);
            throw new DataNotFoundException("No Data for the date " + date + " found !!!");
        }
        return converter.convertCovidDetailstoList(covidDetails);

    }

    @Override
    public List<CovidResponse> getCovidDetailsInDateRange(LocalDate start_date, LocalDate end_date) throws DataNotFoundException {
        return null;
    }
}
