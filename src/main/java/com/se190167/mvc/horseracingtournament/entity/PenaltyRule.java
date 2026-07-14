package com.se190167.mvc.horseracingtournament.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "penalty_rules")
public class PenaltyRule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "rule_name")
    private String ruleName; // Ví dụ: Tranh lane, Tác động phi thể thao

    @Column(name = "point_deduction")
    private Integer pointDeduction;

    @Column(name = "ban_days")
    private Integer banDays;
}