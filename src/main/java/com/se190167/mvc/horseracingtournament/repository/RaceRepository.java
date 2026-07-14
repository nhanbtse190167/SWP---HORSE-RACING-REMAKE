package com.se190167.mvc.horseracingtournament.repository;

import com.se190167.mvc.horseracingtournament.entity.Race;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface RaceRepository extends JpaRepository<Race, Integer> {

    // Lấy danh sách cuộc đua sau một thời điểm nhất định
    List<Race> findByRaceDatetimeAfter(LocalDateTime dateTime);

    // Lấy danh sách cuộc đua trong một khoảng thời gian
    List<Race> findByRaceDatetimeBetween(LocalDateTime start, LocalDateTime end);

    // Lấy danh sách cuộc đua theo trạng thái (Ví dụ: "UPCOMING", "FINISHED")
    List<Race> findByStatus(String status);
}