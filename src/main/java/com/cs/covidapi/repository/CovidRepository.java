package com.cs.covidapi.repository;

import com.cs.covidapi.model.CovidDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface CovidRepository extends JpaRepository<CovidDetails, Long> {

    public List<CovidDetails> findByCountry(String country);

    public List<CovidDetails> findByLastUpdate(LocalDate date);



}
