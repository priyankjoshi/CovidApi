package com.cs.covidapi.converter;

import com.cs.covidapi.dto.CovidResponse;
import com.cs.covidapi.model.CovidDetails;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Component
public class CovidDetailsConverter {

    @Autowired
    private ModelMapper mapper;

    public Optional<CovidResponse> convertCovidDetails(List<CovidDetails>  covidDetails){

        return covidDetails.stream().map(cdetails -> mapper.map(cdetails,CovidResponse.class))
                .findFirst();

    }

    public List<CovidResponse> convertCovidDetailstoList(List<CovidDetails>  covidDetails){

        return covidDetails.stream().map(cdetails -> mapper.map(cdetails,CovidResponse.class))
                .collect(Collectors.toList());

    }




}
