package com.cs.covidapi.dto;

import java.time.LocalDate;

public class CovidResponse {

    private String fisp;
    private String admin;
    private String State;
    private String country;
    private LocalDate lastUpdate;
    private String latitude;
    private String longitude;
    private String confirmedCases;
    private String noOfDeaths;
    private String recoveredCases;
    private String activeCases;
    private String combinedKey;
    private String incidentRate;
    private String caseFatalityRatio;

    public String getActiveCases() {
        return activeCases;
    }

    public void setActiveCases(String activeCases) {
        this.activeCases = activeCases;
    }

    public String getFisp() {
        return fisp;
    }

    public void setFisp(String fisp) {
        this.fisp = fisp;
    }

    public String getAdmin() {
        return admin;
    }

    public void setAdmin(String admin) {
        this.admin = admin;
    }

    public String getState() {
        return State;
    }

    public void setState(String state) {
        State = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public LocalDate getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(LocalDate lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getConfirmedCases() {
        return confirmedCases;
    }

    public void setConfirmedCases(String confirmedCases) {
        this.confirmedCases = confirmedCases;
    }

    public String getNoOfDeaths() {
        return noOfDeaths;
    }

    public void setNoOfDeaths(String noOfDeaths) {
        this.noOfDeaths = noOfDeaths;
    }

    public String getRecoveredCases() {
        return recoveredCases;
    }

    public void setRecoveredCases(String recoveredCases) {
        this.recoveredCases = recoveredCases;
    }

    public String getCombinedKey() {
        return combinedKey;
    }

    public void setCombinedKey(String combinedKey) {
        this.combinedKey = combinedKey;
    }

    public String getIncidentRate() {
        return incidentRate;
    }

    public void setIncidentRate(String incidentRate) {
        this.incidentRate = incidentRate;
    }

    public String getCaseFatalityRatio() {
        return caseFatalityRatio;
    }

    public void setCaseFatalityRatio(String caseFatalityRatio) {
        this.caseFatalityRatio = caseFatalityRatio;
    }

    @Override
    public String toString() {
        return "CovidResponse{" +
                "fisp='" + fisp + '\'' +
                ", admin='" + admin + '\'' +
                ", State='" + State + '\'' +
                ", country='" + country + '\'' +
                ", lastUpdate=" + lastUpdate +
                ", latitude='" + latitude + '\'' +
                ", longitude='" + longitude + '\'' +
                ", confirmedCases='" + confirmedCases + '\'' +
                ", noOfDeaths='" + noOfDeaths + '\'' +
                ", recoveredCases='" + recoveredCases + '\'' +
                ", activeCases='" + activeCases + '\'' +
                ", combinedKey='" + combinedKey + '\'' +
                ", incidentRate='" + incidentRate + '\'' +
                ", caseFatalityRatio='" + caseFatalityRatio + '\'' +
                '}';
    }
}
