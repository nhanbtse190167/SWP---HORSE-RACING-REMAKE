package com.se190167.mvc.horseracingtournament.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "referee_assignments")
public class RefereeAssignment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "race_id")
    private Race race;

    @ManyToOne
    @JoinColumn(name = "referee_id")
    private Referee referee;

    private String role; // Ví dụ: Trọng tài chính, Trọng tài biên
}