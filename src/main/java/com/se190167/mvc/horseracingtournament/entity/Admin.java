package com.se190167.mvc.horseracingtournament.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "admins")
public class Admin {
    @Id
    @Column(name = "user_id")
    private Integer userId;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "manage_horses")
    private Boolean manageHorses = false;

    @Column(name = "manage_jockeys")
    private Boolean manageJockeys = false;

    @Column(name = "create_tournaments")
    private Boolean createTournaments = false;

    @Column(name = "issue_regulations")
    private Boolean issueRegulations = false;

    @Column(name = "penalty_rules")
    private Boolean penaltyRules = false;

    @Column(name = "operate_system")
    private Boolean operateSystem = false;

    @OneToMany(mappedBy = "createdByAdmin", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Tournament> tournaments;

    @OneToMany(mappedBy = "issuedByAdmin", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<TournamentRule> tournamentRules;

    @OneToMany(mappedBy = "admin", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<AdminActivityLog> adminActivityLogs;

    // Getters
    public Integer getUserId() { return userId; }
    public User getUser() { return user; }
    public Boolean getManageHorses() { return manageHorses; }
    public Boolean getManageJockeys() { return manageJockeys; }
    public Boolean getCreateTournaments() { return createTournaments; }
    public Boolean getIssueRegulations() { return issueRegulations; }
    public Boolean getPenaltyRules() { return penaltyRules; }
    public Boolean getOperateSystem() { return operateSystem; }
    public List<Tournament> getTournaments() { return tournaments; }
    public List<TournamentRule> getTournamentRules() { return tournamentRules; }
    public List<AdminActivityLog> getAdminActivityLogs() { return adminActivityLogs; }

    // Setters
    public void setUserId(Integer userId) { this.userId = userId; }
    public void setUser(User user) { this.user = user; }
    public void setManageHorses(Boolean manageHorses) { this.manageHorses = manageHorses; }
    public void setManageJockeys(Boolean manageJockeys) { this.manageJockeys = manageJockeys; }
    public void setCreateTournaments(Boolean createTournaments) { this.createTournaments = createTournaments; }
    public void setIssueRegulations(Boolean issueRegulations) { this.issueRegulations = issueRegulations; }
    public void setPenaltyRules(Boolean penaltyRules) { this.penaltyRules = penaltyRules; }
    public void setOperateSystem(Boolean operateSystem) { this.operateSystem = operateSystem; }
    public void setTournaments(List<Tournament> tournaments) { this.tournaments = tournaments; }
    public void setTournamentRules(List<TournamentRule> tournamentRules) { this.tournamentRules = tournamentRules; }
    public void setAdminActivityLogs(List<AdminActivityLog> adminActivityLogs) { this.adminActivityLogs = adminActivityLogs; }
}