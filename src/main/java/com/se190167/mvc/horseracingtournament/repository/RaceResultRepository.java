package com.se190167.mvc.horseracingtournament.repository;

import com.se190167.mvc.horseracingtournament.entity.Race;
import com.se190167.mvc.horseracingtournament.entity.RaceResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface RaceResultRepository extends JpaRepository<RaceResult, Integer> {

    // Đếm số chiến thắng (hạng 1) của một chủ ngựa
    @Query("SELECT COUNT(rr) FROM RaceResult rr WHERE rr.raceEntry.owner.userId = :ownerId AND rr.position = 1")
    Integer countWinsByOwnerId(@Param("ownerId") Integer ownerId);

    // Đếm số chiến thắng (hạng 1) của một kỵ sĩ
    @Query("SELECT COUNT(rr) FROM RaceResult rr WHERE rr.raceEntry.jockey.userId = :jockeyId AND rr.position = 1")
    Integer countWinsByJockeyId(@Param("jockeyId") Integer jockeyId);

    // Tính tổng điểm của một kỵ sĩ (Ví dụ: 10 điểm cho hạng 1, 9 điểm cho hạng 2, ...)
    @Query("SELECT SUM(10 - rr.position) FROM RaceResult rr WHERE rr.raceEntry.jockey.userId = :jockeyId AND rr.position <= 10")
    Integer sumPointsByJockeyId(@Param("jockeyId") Integer jockeyId);

    // Lấy kết quả các cuộc đua của một chủ ngựa (kèm thông tin)
    @Query("SELECT rr FROM RaceResult rr WHERE rr.raceEntry.owner.userId = :ownerId")
    List<RaceResult> findByOwnerId(@Param("ownerId") Integer ownerId);

    // Lấy danh sách các cuộc đua mà một chủ ngựa đã tham gia
    @Query("SELECT rr.race FROM RaceResult rr WHERE rr.raceEntry.owner.userId = :ownerId")
    List<Race> findRaceByOwnerId(@Param("ownerId") Integer ownerId);

    // Lấy danh sách các cuộc đua mà một kỵ sĩ đã tham gia
    @Query("SELECT rr.race FROM RaceResult rr WHERE rr.raceEntry.jockey.userId = :jockeyId")
    List<Race> findRaceByJockeyId(@Param("jockeyId") Integer jockeyId);

    // Lấy danh sách các cuộc đua sắp tới của một kỵ sĩ
    @Query("SELECT rr.race FROM RaceResult rr WHERE rr.raceEntry.jockey.userId = :jockeyId AND rr.race.raceDatetime > :now")
    List<Race> findUpcomingRaceByJockeyId(@Param("jockeyId") Integer jockeyId, @Param("now") LocalDateTime now);

    // Lấy danh sách kết quả chưa được xác nhận bởi trọng tài
    List<RaceResult> findByConfirmedByRefereeIsNull();
}