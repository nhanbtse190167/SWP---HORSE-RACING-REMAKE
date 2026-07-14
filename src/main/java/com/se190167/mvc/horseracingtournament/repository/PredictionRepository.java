package com.se190167.mvc.horseracingtournament.repository;

import com.se190167.mvc.horseracingtournament.entity.SpectatorPrediction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PredictionRepository extends JpaRepository<SpectatorPrediction, Integer> {

    @Query("SELECT SUM(sp.pointsAwarded) FROM SpectatorPrediction sp WHERE sp.spectator.userId = :userId")
    Integer sumPointsBySpectatorId(@Param("userId") Integer userId);

    @Query("SELECT sp FROM SpectatorPrediction sp WHERE sp.spectator.userId = :userId")
    List<SpectatorPrediction> findBySpectatorUserId(@Param("userId") Integer userId);

    @Query("SELECT sp.spectator.userId, SUM(sp.pointsAwarded) as total " +
            "FROM SpectatorPrediction sp " +
            "GROUP BY sp.spectator.userId " +
            "ORDER BY total DESC")
    List<Object[]> getGlobalRanking();

    @Query("SELECT COUNT(DISTINCT sp2.spectator.userId) + 1 " +
            "FROM SpectatorPrediction sp2 " +
            "GROUP BY sp2.spectator.userId " +
            "HAVING SUM(sp2.pointsAwarded) > (SELECT SUM(sp.pointsAwarded) FROM SpectatorPrediction sp WHERE sp.spectator.userId = :userId)")
    Integer findRankBySpectatorId(@Param("userId") Integer userId);
}