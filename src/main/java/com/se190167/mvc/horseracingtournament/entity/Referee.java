package com.se190167.mvc.horseracingtournament.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "referees")
public class Referee {
    @Id
    @Column(name = "user_id")
    private Integer userId;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "license_number", length = 100)
    private String licenseNumber;

    @Column(length = 50)
    private String status;

    @OneToMany(mappedBy = "referee", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<RefereeAssignment> refereeAssignments;

    @OneToMany(mappedBy = "confirmedByReferee", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<RaceResult> raceResults;

    @OneToMany(mappedBy = "referee", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Violation> violations;

    // Getters
    public Integer getUserId() { return userId; }
    public User getUser() { return user; }
    public String getLicenseNumber() { return licenseNumber; }
    public String getStatus() { return status; }
    public List<RefereeAssignment> getRefereeAssignments() { return refereeAssignments; }
    public List<RaceResult> getRaceResults() { return raceResults; }
    public List<Violation> getViolations() { return violations; }

    // Setters
    public void setUserId(Integer userId) { this.userId = userId; }
    public void setUser(User user) { this.user = user; }
    public void setLicenseNumber(String licenseNumber) { this.licenseNumber = licenseNumber; }
    public void setStatus(String status) { this.status = status; }
    public void setRefereeAssignments(List<RefereeAssignment> refereeAssignments) { this.refereeAssignments = refereeAssignments; }
    public void setRaceResults(List<RaceResult> raceResults) { this.raceResults = raceResults; }
    public void setViolations(List<Violation> violations) { this.violations = violations; }
}