package com.se190167.mvc.horseracingtournament.repository;

import com.se190167.mvc.horseracingtournament.entity.Horse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HorseRepository extends JpaRepository<Horse, Integer> {

    List<Horse> findByOwnerUserId(Integer ownerId);

    @Query("SELECT h FROM Horse h WHERE h.name LIKE %:keyword% OR h.breed LIKE %:keyword%")
    List<Horse> searchHorses(@Param("keyword") String keyword);

    List<Horse> findTop5ByOrderByIdDesc();
}