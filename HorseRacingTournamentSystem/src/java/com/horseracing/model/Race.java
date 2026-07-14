package com.horseracing.model;

import java.util.Date;

public class Race {
    private int id;
    private String raceCode;
    private String raceName;
    private String raceType; // FLAT, HURDLE, STEEPLECHASE
    private int distance;
    private double weightRequirement;
    private int minAge;
    private int maxAge;
    private double prizeMoney;
    private Date raceDate;
    private String raceTime;
    private String venue;
    private String trackCondition; // FIRM, GOOD, SOFT, HEAVY, YIELDING
    private String weatherForecast;
    private int maxParticipants;
    private int minParticipants;
    private String status; // DRAFT, OPEN_REGISTRATION, CLOSED, ...
    private boolean resultDeclared;
    private Date resultDeclaredAt;
    private Date createdAt;
    private Date updatedAt;
    private Integer createdBy;
    private Integer approvedBy;
    private Date approvedAt;

    // Constructor
    public Race() {
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRaceCode() {
        return raceCode;
    }

    public void setRaceCode(String raceCode) {
        this.raceCode = raceCode;
    }

    public String getRaceName() {
        return raceName;
    }

    public void setRaceName(String raceName) {
        this.raceName = raceName;
    }

    public String getRaceType() {
        return raceType;
    }

    public void setRaceType(String raceType) {
        this.raceType = raceType;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public double getWeightRequirement() {
        return weightRequirement;
    }

    public void setWeightRequirement(double weightRequirement) {
        this.weightRequirement = weightRequirement;
    }

    public int getMinAge() {
        return minAge;
    }

    public void setMinAge(int minAge) {
        this.minAge = minAge;
    }

    public int getMaxAge() {
        return maxAge;
    }

    public void setMaxAge(int maxAge) {
        this.maxAge = maxAge;
    }

    public double getPrizeMoney() {
        return prizeMoney;
    }

    public void setPrizeMoney(double prizeMoney) {
        this.prizeMoney = prizeMoney;
    }

    public Date getRaceDate() {
        return raceDate;
    }

    public void setRaceDate(Date raceDate) {
        this.raceDate = raceDate;
    }

    public String getRaceTime() {
        return raceTime;
    }

    public void setRaceTime(String raceTime) {
        this.raceTime = raceTime;
    }

    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    public String getTrackCondition() {
        return trackCondition;
    }

    public void setTrackCondition(String trackCondition) {
        this.trackCondition = trackCondition;
    }

    public String getWeatherForecast() {
        return weatherForecast;
    }

    public void setWeatherForecast(String weatherForecast) {
        this.weatherForecast = weatherForecast;
    }

    public int getMaxParticipants() {
        return maxParticipants;
    }

    public void setMaxParticipants(int maxParticipants) {
        this.maxParticipants = maxParticipants;
    }

    public int getMinParticipants() {
        return minParticipants;
    }

    public void setMinParticipants(int minParticipants) {
        this.minParticipants = minParticipants;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public boolean isResultDeclared() {
        return resultDeclared;
    }

    public void setResultDeclared(boolean resultDeclared) {
        this.resultDeclared = resultDeclared;
    }

    public Date getResultDeclaredAt() {
        return resultDeclaredAt;
    }

    public void setResultDeclaredAt(Date resultDeclaredAt) {
        this.resultDeclaredAt = resultDeclaredAt;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Integer getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
    }

    public Integer getApprovedBy() {
        return approvedBy;
    }

    public void setApprovedBy(Integer approvedBy) {
        this.approvedBy = approvedBy;
    }

    public Date getApprovedAt() {
        return approvedAt;
    }

    public void setApprovedAt(Date approvedAt) {
        this.approvedAt = approvedAt;
    }
}