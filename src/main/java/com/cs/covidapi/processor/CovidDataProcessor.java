package com.cs.covidapi.processor;

import com.cs.covidapi.data.CovidData;
import com.cs.covidapi.model.CovidDetails;
import org.springframework.batch.item.ItemProcessor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CovidDataProcessor implements ItemProcessor<CovidData, CovidDetails> {
    @Override
    public CovidDetails process(CovidData item) throws Exception {

        CovidDetails details = new CovidDetails();
        details.setFisp(item.getFIPS());
        details.setAdmin(item.getAdmin2());
        details.setState(item.getProvince_State());
        details.setCountry(item.getCountry_Region());
        details.setLastUpdate(getLocalDate(item));
        details.setLatitude(item.getLat());
        details.setLongitude(item.getLong_());
        details.setConfirmedCases(item.getConfirmed());
        details.setNoOfDeaths(item.getDeaths());
        details.setRecoveredCases(item.getRecovered());
        details.setActiveCases(item.getActive());
        details.setCombinedKey(item.getCombined_Key());
        details.setIncidentRate(item.getIncident_Rate());
        details.setCaseFatalityRatio(item.getCase_Fatality_Ratio());

        return details;
    }

    private LocalDate getLocalDate(CovidData item) {
        final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return LocalDateTime.parse(item.getLast_Update(),dtf).toLocalDate();

        /**
         * To work on dates save only the date to the database
         * LocalDateTime localDateTime =  LocalDateTime.parse(item.getLast_Update(),dtf);
         *         LocalDate date =localDateTime.toLocalDate();
         *     }
         */

    }
}
