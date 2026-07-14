package com.se190167.mvc.horseracingtournament.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "races")
public class Race {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tournament_id")
    private Tournament tournament;

    @Column(nullable = false, length = 255)
    private String name;

    @Column(name = "race_datetime")
    private LocalDateTime raceDatetime;

    @Column(length = 50)
    private String status;

    private Double distance;

    @Column(name = "age_limit")
    private Integer ageLimit;

    @Column(name = "weight_requirement")
    private Double weightRequirement;

    @OneToMany(mappedBy = "race", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<RaceEntry> raceEntries;

    @OneToMany(mappedBy = "race", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<RefereeAssignment> refereeAssignments;

    @OneToMany(mappedBy = "race", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<SpectatorPrediction> spectatorPredictions;

    @OneToMany(mappedBy = "race", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<RaceResult> raceResults;

    @OneToMany(mappedBy = "race", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Violation> violations;

    // Getters
    public Integer getId() { return id; }
    public Tournament getTournament() { return tournament; }
    public String getName() { return name; }
    public LocalDateTime getRaceDatetime() { return raceDatetime; }
    public String getStatus() { return status; }
    public Double getDistance() { return distance; }
    public Integer getAgeLimit() { return ageLimit; }
    public Double getWeightRequirement() { return weightRequirement; }
    public List<RaceEntry> getRaceEntries() { return raceEntries; }
    public List<RefereeAssignment> getRefereeAssignments() { return refereeAssignments; }
    public List<SpectatorPrediction> getSpectatorPredictions() { return spectatorPredictions; }
    public List<RaceResult> getRaceResults() { return raceResults; }
    public List<Violation> getViolations() { return violations; }

    // Setters
    public void setId(Integer id) { this.id = id; }
    public void setTournament(Tournament tournament) { this.tournament = tournament; }
    public void setName(String name) { this.name = name; }
    public void setRaceDatetime(LocalDateTime raceDatetime) { this.raceDatetime = raceDatetime; }
    public void setStatus(String status) { this.status = status; }
    public void setDistance(Double distance) { this.distance = distance; }
    public void setAgeLimit(Integer ageLimit) { this.ageLimit = ageLimit; }
    public void setWeightRequirement(Double weightRequirement) { this.weightRequirement = weightRequirement; }
    public void setRaceEntries(List<RaceEntry> raceEntries) { this.raceEntries = raceEntries; }
    public void setRefereeAssignments(List<RefereeAssignment> refereeAssignments) { this.refereeAssignments = refereeAssignments; }
    public void setSpectatorPredictions(List<SpectatorPrediction> spectatorPredictions) { this.spectatorPredictions = spectatorPredictions; }
    public void setRaceResults(List<RaceResult> raceResults) { this.raceResults = raceResults; }
    public void setViolations(List<Violation> violations) { this.violations = violations; }
}