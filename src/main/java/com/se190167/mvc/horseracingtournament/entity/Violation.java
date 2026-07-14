package com.se190167.mvc.horseracingtournament.entity;

import jakarta.persistence.*;

@SuppressWarnings("unused") // Tắt cảnh báo cho toàn bộ class này
@Entity
@Table(name = "violations")
public class Violation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "race_id")
    private Race race;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "race_entry_id")
    private RaceEntry raceEntry;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "referee_id")
    private Referee referee;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "penalty_rule_id")
    private PenaltyRule penaltyRule;

    @Column(name = "violation_name", length = 255)
    private String violationName;

    @Column(name = "penalty_applied", columnDefinition = "NVARCHAR(MAX)")
    private String penaltyApplied;

    @Column(length = 50)
    private String status;

    // ==================== GETTERS ====================
    public Integer getId() { return id; }
    public Race getRace() { return race; }
    public RaceEntry getRaceEntry() { return raceEntry; }
    public Referee getReferee() { return referee; }
    public PenaltyRule getPenaltyRule() { return penaltyRule; }
    public String getViolationName() { return violationName; }
    public String getPenaltyApplied() { return penaltyApplied; }
    public String getStatus() { return status; }

    // ==================== SETTERS ====================
    public void setId(Integer id) { this.id = id; }
    public void setRace(Race race) { this.race = race; }
    public void setRaceEntry(RaceEntry raceEntry) { this.raceEntry = raceEntry; }
    public void setReferee(Referee referee) { this.referee = referee; }
    public void setPenaltyRule(PenaltyRule penaltyRule) { this.penaltyRule = penaltyRule; }
    public void setViolationName(String violationName) { this.violationName = violationName; }
    public void setPenaltyApplied(String penaltyApplied) { this.penaltyApplied = penaltyApplied; }
    public void setStatus(String status) { this.status = status; }
}