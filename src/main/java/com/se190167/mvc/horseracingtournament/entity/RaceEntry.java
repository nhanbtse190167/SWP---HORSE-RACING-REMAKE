package com.se190167.mvc.horseracingtournament.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "race_entries")
public class RaceEntry {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "race_id")
    private Race race;

    @ManyToOne
    @JoinColumn(name = "horse_id")
    private Horse horse;

    @ManyToOne
    @JoinColumn(name = "jockey_id")
    private Jockey jockey;

    @Column(name = "lane_number")
    private Integer laneNumber;
}