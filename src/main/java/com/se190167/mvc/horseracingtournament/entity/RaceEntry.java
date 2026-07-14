package com.se190167.mvc.horseracingtournament.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "race_entries")
public class RaceEntry {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "race_id")
    private Race race;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "horse_id")
    private Horse horse;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner_id")
    private HorseOwner owner;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "jockey_id")
    private Jockey jockey;

    @Column(name = "lane_number")
    private Integer laneNumber;

    @Column(name = "registration_status", length = 50)
    private String registrationStatus;

    @OneToMany(mappedBy = "raceEntry", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<RaceResult> raceResults;

    @OneToMany(mappedBy = "raceEntry", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Violation> violations;

    // Getters
    public Integer getId() { return id; }
    public Race getRace() { return race; }
    public Horse getHorse() { return horse; }
    public HorseOwner getOwner() { return owner; }
    public Jockey getJockey() { return jockey; }
    public Integer getLaneNumber() { return laneNumber; }
    public String getRegistrationStatus() { return registrationStatus; }
    public List<RaceResult> getRaceResults() { return raceResults; }
    public List<Violation> getViolations() { return violations; }

    // Setters
    public void setId(Integer id) { this.id = id; }
    public void setRace(Race race) { this.race = race; }
    public void setHorse(Horse horse) { this.horse = horse; }
    public void setOwner(HorseOwner owner) { this.owner = owner; }
    public void setJockey(Jockey jockey) { this.jockey = jockey; }
    public void setLaneNumber(Integer laneNumber) { this.laneNumber = laneNumber; }
    public void setRegistrationStatus(String registrationStatus) { this.registrationStatus = registrationStatus; }
    public void setRaceResults(List<RaceResult> raceResults) { this.raceResults = raceResults; }
    public void setViolations(List<Violation> violations) { this.violations = violations; }
}