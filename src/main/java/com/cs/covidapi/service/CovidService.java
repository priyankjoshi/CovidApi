package com.cs.covidapi.service;

import com.cs.covidapi.dto.CovidResponse;
import com.cs.covidapi.exception.DataNotFoundException;

import java.time.LocalDate;
import java.util.List;


public interface CovidService {

    public CovidResponse getCovidDetailsByCountryName(String country)throws DataNotFoundException;

    public List<CovidResponse> getCovidDetailsByDateFilter(LocalDate date) throws DataNotFoundException;

    public List<CovidResponse> getCovidDetailsInDateRange(LocalDate start_date, LocalDate end_date) throws DataNotFoundException;
}
