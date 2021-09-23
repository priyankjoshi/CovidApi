package com.cs.covidapi.resource;

import com.cs.covidapi.dto.CovidResponse;
import com.cs.covidapi.service.CovidService;
import org.springframework.web.bind.MissingRequestValueException;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class CovidResource {


    private CovidService covidService;


    public CovidResource(CovidService covidService){
        this.covidService = covidService;
    }


    @GetMapping("/covid/{country}")
    public CovidResponse getCovidDetails(@PathVariable(name = "country") String country) {
        return covidService.getCovidDetailsByCountryName(country);
    }

    @GetMapping("/covid/details")
    public List<CovidResponse> getCovidDetailsForDate(@RequestParam String date){
        final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return covidService.getCovidDetailsByDateFilter(LocalDate.parse(date,dtf));

    }

    @GetMapping("/covid/details/range")
    public List<CovidResponse> getCovidDetailsForDateRange(@RequestParam String start_date, @RequestParam String end_date) throws MissingRequestValueException {

        if (!start_date.isEmpty() && !end_date.isEmpty()) {
            final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");

            return covidService.getCovidDetailsInDateRange(LocalDate.parse(start_date, dtf), LocalDate.parse(end_date, dtf));

        }
        throw new MissingRequestValueException("Date values should be present.");
    }
}