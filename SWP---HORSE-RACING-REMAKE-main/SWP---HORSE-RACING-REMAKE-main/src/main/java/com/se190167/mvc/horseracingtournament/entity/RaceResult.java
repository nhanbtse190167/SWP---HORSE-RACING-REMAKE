package com.se190167.mvc.horseracingtournament.entity;

import jakarta.persistence.*;
import java.time.LocalTime;

@Entity
@Table(name = "race_results")
public class RaceResult {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "race_id")
    private Race race;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "race_entry_id")
    private RaceEntry raceEntry;

    private Integer position;

    @Column(name = "finish_time")
    private LocalTime finishTime;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "confirmed_by_referee")
    private Referee confirmedByReferee;

    // Getters and Setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public Race getRace() { return race; }
    public void setRace(Race race) { this.race = race; }

    public RaceEntry getRaceEntry() { return raceEntry; }
    public void setRaceEntry(RaceEntry raceEntry) { this.raceEntry = raceEntry; }

    public Integer getPosition() { return position; }
    public void setPosition(Integer position) { this.position = position; }

    public LocalTime getFinishTime() { return finishTime; }
    public void setFinishTime(LocalTime finishTime) { this.finishTime = finishTime; }

    public Referee getConfirmedByReferee() { return confirmedByReferee; }
    public void setConfirmedByReferee(Referee confirmedByReferee) { this.confirmedByReferee = confirmedByReferee; }
}