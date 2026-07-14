package com.se190167.mvc.horseracingtournament.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "referees")
public class Referee extends User {

    // Chứng chỉ hoặc cấp bậc của trọng tài
    private String certificationLevel;
}