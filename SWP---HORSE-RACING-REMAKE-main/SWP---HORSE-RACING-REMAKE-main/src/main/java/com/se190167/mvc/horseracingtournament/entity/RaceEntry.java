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

    // Getters and Setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public Race getRace() { return race; }
    public void setRace(Race race) { this.race = race; }

    public Horse getHorse() { return horse; }
    public void setHorse(Horse horse) { this.horse = horse; }

    public HorseOwner getOwner() { return owner; }
    public void setOwner(HorseOwner owner) { this.owner = owner; }

    public Jockey getJockey() { return jockey; }
    public void setJockey(Jockey jockey) { this.jockey = jockey; }

    public Integer getLaneNumber() { return laneNumber; }
    public void setLaneNumber(Integer laneNumber) { this.laneNumber = laneNumber; }

    public String getRegistrationStatus() { return registrationStatus; }
    public void setRegistrationStatus(String registrationStatus) { this.registrationStatus = registrationStatus; }

    public List<RaceResult> getRaceResults() { return raceResults; }
    public void setRaceResults(List<RaceResult> raceResults) { this.raceResults = raceResults; }

    public List<Violation> getViolations() { return violations; }
    public void setViolations(List<Violation> violations) { this.violations = violations; }
}