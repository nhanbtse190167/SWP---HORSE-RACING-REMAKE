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

    // Getters and Setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public Tournament getTournament() { return tournament; }
    public void setTournament(Tournament tournament) { this.tournament = tournament; }

    public String getViolationType() { return violationType; }
    public void setViolationType(String violationType) { this.violationType = violationType; }

    public String getPenaltyDescription() { return penaltyDescription; }
    public void setPenaltyDescription(String penaltyDescription) { this.penaltyDescription = penaltyDescription; }

    public Integer getPointDeduction() { return pointDeduction; }
    public void setPointDeduction(Integer pointDeduction) { this.pointDeduction = pointDeduction; }

    public BigDecimal getFineAmount() { return fineAmount; }
    public void setFineAmount(BigDecimal fineAmount) { this.fineAmount = fineAmount; }

    public Integer getBanDays() { return banDays; }
    public void setBanDays(Integer banDays) { this.banDays = banDays; }

    public List<Violation> getViolations() { return violations; }
    public void setViolations(List<Violation> violations) { this.violations = violations; }
}