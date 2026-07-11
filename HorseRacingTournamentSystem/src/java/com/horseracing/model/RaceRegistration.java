package com.horseracing.model;

import java.util.Date;

public class RaceRegistration {
    private int id;
    private int raceId;
    private int horseId;
    private int jockeyId;
    private String registrationCode;
    private Date registrationDate;
    private Double weightAtRegistration;
    private String status; // PENDING, CONFIRMED, REJECTED, WITHDRAWN, READY, COMPLETED
    private String rejectionReason;
    private Integer replacementHorseId;
    private Integer replacementJockeyId;
    private Date confirmedAt;
    private Integer confirmedBy;
    private boolean isEligible;
    private String notes;
    private Date createdAt;
    private Date updatedAt;

    // Constructor
    public RaceRegistration() {
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRaceId() {
        return raceId;
    }

    public void setRaceId(int raceId) {
        this.raceId = raceId;
    }

    public int getHorseId() {
        return horseId;
    }

    public void setHorseId(int horseId) {
        this.horseId = horseId;
    }

    public int getJockeyId() {
        return jockeyId;
    }

    public void setJockeyId(int jockeyId) {
        this.jockeyId = jockeyId;
    }

    public String getRegistrationCode() {
        return registrationCode;
    }

    public void setRegistrationCode(String registrationCode) {
        this.registrationCode = registrationCode;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public Double getWeightAtRegistration() {
        return weightAtRegistration;
    }

    public void setWeightAtRegistration(Double weightAtRegistration) {
        this.weightAtRegistration = weightAtRegistration;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRejectionReason() {
        return rejectionReason;
    }

    public void setRejectionReason(String rejectionReason) {
        this.rejectionReason = rejectionReason;
    }

    public Integer getReplacementHorseId() {
        return replacementHorseId;
    }

    public void setReplacementHorseId(Integer replacementHorseId) {
        this.replacementHorseId = replacementHorseId;
    }

    public Integer getReplacementJockeyId() {
        return replacementJockeyId;
    }

    public void setReplacementJockeyId(Integer replacementJockeyId) {
        this.replacementJockeyId = replacementJockeyId;
    }

    public Date getConfirmedAt() {
        return confirmedAt;
    }

    public void setConfirmedAt(Date confirmedAt) {
        this.confirmedAt = confirmedAt;
    }

    public Integer getConfirmedBy() {
        return confirmedBy;
    }

    public void setConfirmedBy(Integer confirmedBy) {
        this.confirmedBy = confirmedBy;
    }

    public boolean isEligible() {
        return isEligible;
    }

    public void setEligible(boolean eligible) {
        isEligible = eligible;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
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
}