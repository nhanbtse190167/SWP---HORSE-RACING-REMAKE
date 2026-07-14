package com.se190167.mvc.horseracingtournament.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "spectator_predictions")
public class SpectatorPrediction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "spectator_id")
    private Spectator spectator;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "race_id")
    private Race race;

    @Column(name = "predicted_top_1")
    private Integer predictedTop1;

    @Column(name = "predicted_top_2")
    private Integer predictedTop2;

    @Column(name = "predicted_top_3")
    private Integer predictedTop3;

    @Column(length = 50)
    private String status;

    @Column(name = "points_awarded")
    private Integer pointsAwarded = 0;

    // Getters and Setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public Spectator getSpectator() { return spectator; }
    public void setSpectator(Spectator spectator) { this.spectator = spectator; }

    public Race getRace() { return race; }
    public void setRace(Race race) { this.race = race; }

    public Integer getPredictedTop1() { return predictedTop1; }
    public void setPredictedTop1(Integer predictedTop1) { this.predictedTop1 = predictedTop1; }

    public Integer getPredictedTop2() { return predictedTop2; }
    public void setPredictedTop2(Integer predictedTop2) { this.predictedTop2 = predictedTop2; }

    public Integer getPredictedTop3() { return predictedTop3; }
    public void setPredictedTop3(Integer predictedTop3) { this.predictedTop3 = predictedTop3; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public Integer getPointsAwarded() { return pointsAwarded; }
    public void setPointsAwarded(Integer pointsAwarded) { this.pointsAwarded = pointsAwarded; }
}