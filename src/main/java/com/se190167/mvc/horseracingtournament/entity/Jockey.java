package com.se190167.mvc.horseracingtournament.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "jockeys")
public class Jockey {
    @Id
    @Column(name = "user_id")
    private Integer userId;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    @JoinColumn(name = "user_id")
    private User user;

    private Double weight;
    private Double height;

    @Column(name = "experience_years")
    private Integer experienceYears;

    @Column(name = "training_certificate", length = 255)
    private String trainingCertificate;

    @Column(columnDefinition = "NVARCHAR(MAX)")
    private String achievement;

    @Column(length = 50)
    private String status;

    @OneToMany(mappedBy = "jockey", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<RaceEntry> raceEntries;

    // Getters
    public Integer getUserId() { return userId; }
    public User getUser() { return user; }
    public Double getWeight() { return weight; }
    public Double getHeight() { return height; }
    public Integer getExperienceYears() { return experienceYears; }
    public String getTrainingCertificate() { return trainingCertificate; }
    public String getAchievement() { return achievement; }
    public String getStatus() { return status; }
    public List<RaceEntry> getRaceEntries() { return raceEntries; }

    // Setters
    public void setUserId(Integer userId) { this.userId = userId; }
    public void setUser(User user) { this.user = user; }
    public void setWeight(Double weight) { this.weight = weight; }
    public void setHeight(Double height) { this.height = height; }
    public void setExperienceYears(Integer experienceYears) { this.experienceYears = experienceYears; }
    public void setTrainingCertificate(String trainingCertificate) { this.trainingCertificate = trainingCertificate; }
    public void setAchievement(String achievement) { this.achievement = achievement; }
    public void setStatus(String status) { this.status = status; }
    public void setRaceEntries(List<RaceEntry> raceEntries) { this.raceEntries = raceEntries; }
}