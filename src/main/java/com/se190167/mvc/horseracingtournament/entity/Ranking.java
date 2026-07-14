package com.se190167.mvc.horseracingtournament.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "rankings")
public class Ranking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tournament_id")
    private Tournament tournament;

    @Column(name = "ranking_type", length = 50)
    private String rankingType;

    @Column(name = "entity_id")
    private Integer entityId;

    @Column(name = "total_points")
    private Integer totalPoints;

    @Column(name = "rank_position")
    private Integer rankPosition;

    // Getters
    public Integer getId() { return id; }
    public Tournament getTournament() { return tournament; }
    public String getRankingType() { return rankingType; }
    public Integer getEntityId() { return entityId; }
    public Integer getTotalPoints() { return totalPoints; }
    public Integer getRankPosition() { return rankPosition; }

    // Setters
    public void setId(Integer id) { this.id = id; }
    public void setTournament(Tournament tournament) { this.tournament = tournament; }
    public void setRankingType(String rankingType) { this.rankingType = rankingType; }
    public void setEntityId(Integer entityId) { this.entityId = entityId; }
    public void setTotalPoints(Integer totalPoints) { this.totalPoints = totalPoints; }
    public void setRankPosition(Integer rankPosition) { this.rankPosition = rankPosition; }
}