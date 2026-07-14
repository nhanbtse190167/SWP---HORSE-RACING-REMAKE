package com.se190167.mvc.horseracingtournament.service;

import com.se190167.mvc.horseracingtournament.entity.Violation;
import com.se190167.mvc.horseracingtournament.repository.ViolationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ViolationService {

    @Autowired
    private ViolationRepository violationRepository;

    public List<Violation> getAllViolations() {
        return violationRepository.findAll();
    }

    public List<Violation> getPendingViolations() {
        return violationRepository.findByStatus("pending");
    }

    public Violation createViolation(Violation violation) {
        return violationRepository.save(violation);
    }

    public Violation updateViolation(Violation violation) {
        return violationRepository.save(violation);
    }

    public void deleteViolation(Integer id) {
        violationRepository.deleteById(id);
    }
}