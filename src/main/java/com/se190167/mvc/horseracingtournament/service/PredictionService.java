package com.se190167.mvc.horseracingtournament.service;

import com.se190167.mvc.horseracingtournament.entity.Race;
import com.se190167.mvc.horseracingtournament.entity.SpectatorPrediction;
import com.se190167.mvc.horseracingtournament.entity.User;
import com.se190167.mvc.horseracingtournament.repository.PredictionRepository;
import com.se190167.mvc.horseracingtournament.repository.RaceRepository;
import com.se190167.mvc.horseracingtournament.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PredictionService {

    @Autowired
    private PredictionRepository predictionRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RaceRepository raceRepository;

    /**
     * Lấy tổng điểm của khán giả
     */
    public Integer getTotalPoints(Integer userId) {
        Integer points = predictionRepository.sumPointsBySpectatorId(userId);
        return points != null ? points : 0;
    }

    /**
     * Lấy xếp hạng của khán giả
     */
    public Integer getRank(Integer userId) {
        Integer rank = predictionRepository.findRankBySpectatorId(userId);
        return rank != null ? rank : 0;
    }

    /**
     * Lấy danh sách dự đoán của khán giả
     */
    public List<SpectatorPrediction> getPredictionsByUser(Integer userId) {
        return predictionRepository.findBySpectatorUserId(userId);
    }

    /**
     * Tạo dự đoán mới
     */
    public SpectatorPrediction createPrediction(Integer userId, Integer raceId, Integer top1, Integer top2, Integer top3) {
        Optional<User> userOpt = userRepository.findById(userId);
        Optional<Race> raceOpt = raceRepository.findById(raceId);

        if (userOpt.isEmpty() || raceOpt.isEmpty()) {
            throw new RuntimeException("User hoặc Race không tồn tại");
        }

        SpectatorPrediction prediction = new SpectatorPrediction();
        prediction.setSpectator(userOpt.get().getSpectator());
        prediction.setRace(raceOpt.get());
        prediction.setPredictedTop1(top1);
        prediction.setPredictedTop2(top2);
        prediction.setPredictedTop3(top3);
        prediction.setStatus("pending");
        prediction.setPointsAwarded(0);

        return predictionRepository.save(prediction);
    }

    /**
     * Lấy bảng xếp hạng toàn cầu
     */
    public List<Object[]> getGlobalRanking() {
        return predictionRepository.getGlobalRanking();
    }
}