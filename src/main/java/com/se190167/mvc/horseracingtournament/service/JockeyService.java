package com.se190167.mvc.horseracingtournament.service;

import com.se190167.mvc.horseracingtournament.entity.Jockey;
import com.se190167.mvc.horseracingtournament.repository.JockeyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JockeyService {

    @Autowired
    private JockeyRepository jockeyRepository;

    public List<Jockey> getAllJockeys() {
        return jockeyRepository.findAll();
    }

    public Optional<Jockey> getJockeyById(Integer id) {
        return jockeyRepository.findById(id);
    }

    public Optional<Jockey> getJockeyByUserId(Integer userId) {
        return jockeyRepository.findByUserId(userId);
    }

    public Jockey createJockey(Jockey jockey) {
        return jockeyRepository.save(jockey);
    }

    public Jockey updateJockey(Jockey jockey) {
        return jockeyRepository.save(jockey);
    }

    public void deleteJockey(Integer id) {
        jockeyRepository.deleteById(id);
    }

    public List<Jockey> getJockeysByStatus(String status) {
        return jockeyRepository.findByStatus(status);
    }
}