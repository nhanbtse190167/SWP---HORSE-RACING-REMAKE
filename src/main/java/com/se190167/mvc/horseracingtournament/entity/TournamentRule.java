package com.se190167.mvc.horseracingtournament.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "tournament_rules")
public class TournamentRule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tournament_id")
    private Tournament tournament;

    @Column(name = "rule_title", length = 255)
    private String ruleTitle;

    @Column(name = "rule_content", columnDefinition = "NVARCHAR(MAX)")
    private String ruleContent;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "issued_by_admin_id")
    private Admin issuedByAdmin;

    // Getters
    public Integer getId() { return id; }
    public Tournament getTournament() { return tournament; }
    public String getRuleTitle() { return ruleTitle; }
    public String getRuleContent() { return ruleContent; }
    public Admin getIssuedByAdmin() { return issuedByAdmin; }

    // Setters
    public void setId(Integer id) { this.id = id; }
    public void setTournament(Tournament tournament) { this.tournament = tournament; }
    public void setRuleTitle(String ruleTitle) { this.ruleTitle = ruleTitle; }
    public void setRuleContent(String ruleContent) { this.ruleContent = ruleContent; }
    public void setIssuedByAdmin(Admin issuedByAdmin) { this.issuedByAdmin = issuedByAdmin; }
}