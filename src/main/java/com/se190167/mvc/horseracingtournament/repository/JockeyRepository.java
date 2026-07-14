package com.se190167.mvc.horseracingtournament.repository;

import com.se190167.mvc.horseracingtournament.entity.Jockey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface JockeyRepository extends JpaRepository<Jockey, Integer> {

    Optional<Jockey> findByUserId(Integer userId);

    List<Jockey> findByStatus(String status);
}