package com.horseracing.model;

import java.util.Date;

public class Horse {
    private int id;
    private int ownerId;
    private String horseCode;
    private String rfid;
    private String name;
    private String breed;
    private String color;
    private String gender; // MALE, FEMALE, GELDING
    private Date dateOfBirth;
    private Double weight;
    private Double height;
    private String originCountry;
    private String healthStatus; // EXCELLENT, GOOD, FAIR, POOR, CRITICAL
    private boolean isEligible;
    private boolean isActive;
    private Date retiredDate;
    private Date createdAt;
    private Date updatedAt;
    private Integer createdBy;
    
    // Constructors
    public Horse() {}
    
    public Horse(int id, String name, String breed, String color, int ownerId) {
        this.id = id;
        this.name = name;
        this.breed = breed;
        this.color = color;
        this.ownerId = ownerId;
    }
    
    // Getters & Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    
    public int getOwnerId() { return ownerId; }
    public void setOwnerId(int ownerId) { this.ownerId = ownerId; }
    
    public String getHorseCode() { return horseCode; }
    public void setHorseCode(String horseCode) { this.horseCode = horseCode; }
    
    public String getRfid() { return rfid; }
    public void setRfid(String rfid) { this.rfid = rfid; }
    
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    
    public String getBreed() { return breed; }
    public void setBreed(String breed) { this.breed = breed; }
    
    public String getColor() { return color; }
    public void setColor(String color) { this.color = color; }
    
    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }
    
    public Date getDateOfBirth() { return dateOfBirth; }
    public void setDateOfBirth(Date dateOfBirth) { this.dateOfBirth = dateOfBirth; }
    
    public Double getWeight() { return weight; }
    public void setWeight(Double weight) { this.weight = weight; }
    
    public Double getHeight() { return height; }
    public void setHeight(Double height) { this.height = height; }
    
    public String getOriginCountry() { return originCountry; }
    public void setOriginCountry(String originCountry) { this.originCountry = originCountry; }
    
    public String getHealthStatus() { return healthStatus; }
    public void setHealthStatus(String healthStatus) { this.healthStatus = healthStatus; }
    
    public boolean isEligible() { return isEligible; }
    public void setEligible(boolean eligible) { isEligible = eligible; }
    
    public boolean isActive() { return isActive; }
    public void setActive(boolean active) { isActive = active; }
    
    public Date getRetiredDate() { return retiredDate; }
    public void setRetiredDate(Date retiredDate) { this.retiredDate = retiredDate; }
    
    public Date getCreatedAt() { return createdAt; }
    public void setCreatedAt(Date createdAt) { this.createdAt = createdAt; }
    
    public Date getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(Date updatedAt) { this.updatedAt = updatedAt; }
    
    public Integer getCreatedBy() { return createdBy; }
    public void setCreatedBy(Integer createdBy) { this.createdBy = createdBy; }
    
    @Override
    public String toString() {
        return "Horse{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", breed='" + breed + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}