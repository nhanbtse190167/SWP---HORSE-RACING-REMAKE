package com.se190167.mvc.horseracingtournament.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "referee_assignments")
public class RefereeAssignment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "referee_id")
    private Referee referee;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "race_id")
    private Race race;

    @Column(name = "assignment_role", length = 100)
    private String assignmentRole;

    // Getters and Setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public Referee getReferee() { return referee; }
    public void setReferee(Referee referee) { this.referee = referee; }

    public Race getRace() { return race; }
    public void setRace(Race race) { this.race = race; }

    public String getAssignmentRole() { return assignmentRole; }
    public void setAssignmentRole(String assignmentRole) { this.assignmentRole = assignmentRole; }
}