package com.se190167.mvc.horseracingtournament.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "horse_owners")
public class HorseOwner extends User {
    @Column(name = "company_name")
    private String companyName;
}