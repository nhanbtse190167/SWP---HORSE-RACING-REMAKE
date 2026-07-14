package com.se190167.mvc.horseracingtournament.service;

import com.se190167.mvc.horseracingtournament.entity.Horse;
import com.se190167.mvc.horseracingtournament.repository.HorseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HorseService {

    @Autowired
    private HorseRepository horseRepository;

    public List<Horse> getAllHorses() {
        return horseRepository.findAll();
    }

    public Optional<Horse> getHorseById(Integer id) {
        return horseRepository.findById(id);
    }

    public List<Horse> getHorsesByOwnerId(Integer ownerId) {
        return horseRepository.findByOwnerUserId(ownerId);
    }

    public Horse createHorse(Horse horse) {
        return horseRepository.save(horse);
    }

    public Horse updateHorse(Horse horse) {
        return horseRepository.save(horse);
    }

    public void deleteHorse(Integer id) {
        horseRepository.deleteById(id);
    }

    public List<Horse> searchHorses(String keyword) {
        return horseRepository.searchHorses(keyword);
    }

    public List<Horse> getRecentHorses(int limit) {
        return horseRepository.findTop5ByOrderByIdDesc();
    }
}