package com.se190167.mvc.horseracingtournament.service;

import com.se190167.mvc.horseracingtournament.entity.Race;
import com.se190167.mvc.horseracingtournament.entity.RaceResult;
import com.se190167.mvc.horseracingtournament.repository.RaceRepository;
import com.se190167.mvc.horseracingtournament.repository.RaceResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class RaceService {

    @Autowired
    private RaceRepository raceRepository;

    @Autowired
    private RaceResultRepository raceResultRepository;

    public List<Race> getAllRaces() {
        return raceRepository.findAll();
    }

    public List<Race> getUpcomingRaces() {
        return raceRepository.findByRaceDatetimeAfter(LocalDateTime.now());
    }

    public List<Race> getTodayRaces() {
        LocalDateTime start = LocalDateTime.now().withHour(0).withMinute(0);
        LocalDateTime end = LocalDateTime.now().withHour(23).withMinute(59);
        return raceRepository.findByRaceDatetimeBetween(start, end);
    }

    public List<Race> getRacesForOwner(Integer ownerId) {
        return raceResultRepository.findRaceByOwnerId(ownerId);
    }

    public List<Race> getRacesForJockey(Integer jockeyId) {
        return raceResultRepository.findRaceByJockeyId(jockeyId);
    }

    public List<Race> getUpcomingRacesForJockey(Integer jockeyId) {
        return raceResultRepository.findUpcomingRaceByJockeyId(jockeyId, LocalDateTime.now());
    }

    public Integer getWinsForOwner(Integer ownerId) {
        return raceResultRepository.countWinsByOwnerId(ownerId);
    }

    public Integer getWinsForJockey(Integer jockeyId) {
        return raceResultRepository.countWinsByJockeyId(jockeyId);
    }

    public Integer getPointsForJockey(Integer jockeyId) {
        Integer points = raceResultRepository.sumPointsByJockeyId(jockeyId);
        return points != null ? points : 0;
    }

    public List<RaceResult> getResultsForOwner(Integer ownerId) {
        return raceResultRepository.findByOwnerId(ownerId);
    }

    public List<RaceResult> getPendingResults() {
        return raceResultRepository.findByConfirmedByRefereeIsNull();
    }

    public List<RaceResult> getAllResults() {
        return raceResultRepository.findAll();
    }
}