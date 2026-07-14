package com.se190167.mvc.horseracingtournament.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "spectators")
public class Spectator {
    @Id
    @Column(name = "user_id")
    private Integer userId;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "total_prediction_points")
    private Integer totalPredictionPoints = 0;

    @Column(length = 50)
    private String status;

    @OneToMany(mappedBy = "spectator", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<SpectatorPrediction> spectatorPredictions;

    // Getters and Setters
    public Integer getUserId() { return userId; }
    public void setUserId(Integer userId) { this.userId = userId; }

    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }

    public Integer getTotalPredictionPoints() { return totalPredictionPoints; }
    public void setTotalPredictionPoints(Integer totalPredictionPoints) { this.totalPredictionPoints = totalPredictionPoints; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public List<SpectatorPrediction> getSpectatorPredictions() { return spectatorPredictions; }
    public void setSpectatorPredictions(List<SpectatorPrediction> spectatorPredictions) { this.spectatorPredictions = spectatorPredictions; }
}