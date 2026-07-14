package com.se190167.mvc.horseracingtournament.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "admin_activity_logs")
public class AdminActivityLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "admin_id")
    private Admin admin;

    @Column(name = "action_type", length = 100)
    private String actionType;

    @Column(name = "action_description", columnDefinition = "NVARCHAR(MAX)")
    private String actionDescription;

    // Getters
    public Integer getId() { return id; }
    public Admin getAdmin() { return admin; }
    public String getActionType() { return actionType; }
    public String getActionDescription() { return actionDescription; }

    // Setters
    public void setId(Integer id) { this.id = id; }
    public void setAdmin(Admin admin) { this.admin = admin; }
    public void setActionType(String actionType) { this.actionType = actionType; }
    public void setActionDescription(String actionDescription) { this.actionDescription = actionDescription; }
}