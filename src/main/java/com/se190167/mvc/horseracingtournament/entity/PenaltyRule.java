package com.se190167.mvc.horseracingtournament.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "penalty_rules")
public class PenaltyRule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tournament_id")
    private Tournament tournament;

    @Column(name = "violation_type", length = 100)
    private String violationType;

    @Column(name = "penalty_description", columnDefinition = "NVARCHAR(MAX)")
    private String penaltyDescription;

    @Column(name = "point_deduction")
    private Integer pointDeduction;

    @Column(name = "fine_amount")
    private BigDecimal fineAmount;

    @Column(name = "ban_days")
    private Integer banDays;

    @OneToMany(mappedBy = "penaltyRule", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Violation> violations;

    // Getters
    public Integer getId() { return id; }
    public Tournament getTournament() { return tournament; }
    public String getViolationType() { return violationType; }
    public String getPenaltyDescription() { return penaltyDescription; }
    public Integer getPointDeduction() { return pointDeduction; }
    public BigDecimal getFineAmount() { return fineAmount; }
    public Integer getBanDays() { return banDays; }
    public List<Violation> getViolations() { return violations; }

    // Setters
    public void setId(Integer id) { this.id = id; }
    public void setTournament(Tournament tournament) { this.tournament = tournament; }
    public void setViolationType(String violationType) { this.violationType = violationType; }
    public void setPenaltyDescription(String penaltyDescription) { this.penaltyDescription = penaltyDescription; }
    public void setPointDeduction(Integer pointDeduction) { this.pointDeduction = pointDeduction; }
    public void setFineAmount(BigDecimal fineAmount) { this.fineAmount = fineAmount; }
    public void setBanDays(Integer banDays) { this.banDays = banDays; }
    public void setViolations(List<Violation> violations) { this.violations = violations; }
}