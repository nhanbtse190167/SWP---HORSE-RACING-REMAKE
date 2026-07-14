package com.se190167.mvc.horseracingtournament.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "race_results")
public class RaceResult {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne
    @JoinColumn(name = "race_entry_id")
    private RaceEntry raceEntry;

    private Integer position;

    @Column(name = "finish_time")
    private String finishTime;

    @ManyToOne
    @JoinColumn(name = "confirmed_by_referee")
    private Referee confirmedByReferee;
}