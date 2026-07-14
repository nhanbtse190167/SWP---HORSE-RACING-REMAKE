package com.se190167.mvc.horseracingtournament.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "tournament_rules")
public class TournamentRule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "tournament_id", nullable = false)
    private Tournament tournament;

    @Column(name = "rule_title", nullable = false)
    private String ruleTitle; // Tiêu đề luật (VD: Điều kiện thi đấu, Quy định đăng ký)

    @Column(name = "rule_content", columnDefinition = "NVARCHAR(MAX)")
    private String ruleContent; // Nội dung chi tiết của luật
}