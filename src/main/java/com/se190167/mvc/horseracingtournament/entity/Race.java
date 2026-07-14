package com.se190167.mvc.horseracingtournament.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "races")
public class Race {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "tournament_id")
    private Tournament tournament;

    private String name;

    @Column(name = "race_date")
    private LocalDateTime raceDate;

    private Double distance;
    private String status = "SCHEDULED";
}