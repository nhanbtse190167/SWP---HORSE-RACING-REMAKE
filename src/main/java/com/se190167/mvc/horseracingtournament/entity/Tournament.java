package com.se190167.mvc.horseracingtournament.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "tournaments")
public class Tournament {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 255)
    private String name;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    @Column(length = 50)
    private String status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "created_by_admin_id")
    private Admin createdByAdmin;

    @OneToMany(mappedBy = "tournament", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<TournamentRule> tournamentRules;

    @OneToMany(mappedBy = "tournament", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<PenaltyRule> penaltyRules;

    @OneToMany(mappedBy = "tournament", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Ranking> rankings;

    @OneToMany(mappedBy = "tournament", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Race> races;

    // Getters
    public Integer getId() { return id; }
    public String getName() { return name; }
    public LocalDate getStartDate() { return startDate; }
    public LocalDate getEndDate() { return endDate; }
    public String getStatus() { return status; }
    public Admin getCreatedByAdmin() { return createdByAdmin; }
    public List<TournamentRule> getTournamentRules() { return tournamentRules; }
    public List<PenaltyRule> getPenaltyRules() { return penaltyRules; }
    public List<Ranking> getRankings() { return rankings; }
    public List<Race> getRaces() { return races; }

    // Setters
    public void setId(Integer id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setStartDate(LocalDate startDate) { this.startDate = startDate; }
    public void setEndDate(LocalDate endDate) { this.endDate = endDate; }
    public void setStatus(String status) { this.status = status; }
    public void setCreatedByAdmin(Admin createdByAdmin) { this.createdByAdmin = createdByAdmin; }
    public void setTournamentRules(List<TournamentRule> tournamentRules) { this.tournamentRules = tournamentRules; }
    public void setPenaltyRules(List<PenaltyRule> penaltyRules) { this.penaltyRules = penaltyRules; }
    public void setRankings(List<Ranking> rankings) { this.rankings = rankings; }
    public void setRaces(List<Race> races) { this.races = races; }
}