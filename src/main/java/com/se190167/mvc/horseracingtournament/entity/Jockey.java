package com.se190167.mvc.horseracingtournament.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "jockeys")
public class Jockey extends User {
    private Double weight;

    @Column(name = "experience_years")
    private Integer experienceYears;
}