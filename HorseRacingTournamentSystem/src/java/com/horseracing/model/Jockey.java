package com.horseracing.model;

import java.util.Date;

public class Jockey {
    private int id;
    private int userId;
    private String jockeyCode;
    private double weight;
    private double height;
    private Date dateOfBirth;
    private String nationality;
    private int experienceYears;
    private int tournamentsWon;
    private String certificateUrl;
    private boolean certificateVerified;
    private Date certificateVerifiedAt;
    private String healthStatus; // FIT, UNFIT, INJURED, SUSPENDED
    private Date medicalExpiryDate;
    private double rating;
    private boolean isEligible;
    private Date createdAt;
    private Date updatedAt;

    // Constructor
    public Jockey() {
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getJockeyCode() {
        return jockeyCode;
    }

    public void setJockeyCode(String jockeyCode) {
        this.jockeyCode = jockeyCode;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public int getExperienceYears() {
        return experienceYears;
    }

    public void setExperienceYears(int experienceYears) {
        this.experienceYears = experienceYears;
    }

    public int getTournamentsWon() {
        return tournamentsWon;
    }

    public void setTournamentsWon(int tournamentsWon) {
        this.tournamentsWon = tournamentsWon;
    }

    public String getCertificateUrl() {
        return certificateUrl;
    }

    public void setCertificateUrl(String certificateUrl) {
        this.certificateUrl = certificateUrl;
    }

    public boolean isCertificateVerified() {
        return certificateVerified;
    }

    public void setCertificateVerified(boolean certificateVerified) {
        this.certificateVerified = certificateVerified;
    }

    public Date getCertificateVerifiedAt() {
        return certificateVerifiedAt;
    }

    public void setCertificateVerifiedAt(Date certificateVerifiedAt) {
        this.certificateVerifiedAt = certificateVerifiedAt;
    }

    public String getHealthStatus() {
        return healthStatus;
    }

    public void setHealthStatus(String healthStatus) {
        this.healthStatus = healthStatus;
    }

    public Date getMedicalExpiryDate() {
        return medicalExpiryDate;
    }

    public void setMedicalExpiryDate(Date medicalExpiryDate) {
        this.medicalExpiryDate = medicalExpiryDate;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public boolean isEligible() {
        return isEligible;
    }

    public void setEligible(boolean eligible) {
        isEligible = eligible;
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

    @Override
    public String toString() {
        return "Jockey{" +
                "id=" + id +
                ", jockeyCode='" + jockeyCode + '\'' +
                ", weight=" + weight +
                ", height=" + height +
                '}';
    }
}