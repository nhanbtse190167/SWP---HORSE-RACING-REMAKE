package com.se190167.mvc.horseracingtournament.controller;

import com.se190167.mvc.horseracingtournament.entity.User;
import com.se190167.mvc.horseracingtournament.service.PredictionService;
import com.se190167.mvc.horseracingtournament.service.RaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/spectator")
public class SpectatorController {

    private final RaceService raceService;
    private final PredictionService predictionService;

    @Autowired
    public SpectatorController(RaceService raceService, PredictionService predictionService) {
        this.raceService = raceService;
        this.predictionService = predictionService;
    }

    @GetMapping("/dashboard")
    public String dashboard(Model model, HttpSession session) {
        User user = (User) session.getAttribute("loggedInUser");
        if (user == null || !user.getRole().equals("Spectator")) {
            return "redirect:/login";
        }

        model.addAttribute("pageTitle", "Dashboard Khán Giả");
        model.addAttribute("upcomingRaces", raceService.getUpcomingRaces());
        model.addAttribute("totalPoints", predictionService.getTotalPoints(user.getId()));
        model.addAttribute("rank", predictionService.getRank(user.getId()));
        model.addAttribute("predictions", predictionService.getPredictionsByUser(user.getId()));

        return "spectator-dashboard";
    }

    @GetMapping("/predict")
    public String predict(Model model, HttpSession session) {
        User user = (User) session.getAttribute("loggedInUser");
        if (user == null || !user.getRole().equals("Spectator")) {
            return "redirect:/login";
        }

        model.addAttribute("pageTitle", "Dự Đoán Kết Quả");
        model.addAttribute("upcomingRaces", raceService.getUpcomingRaces());
        return "spectator-predict";
    }

    @PostMapping("/predict")
    public String doPredict(@RequestParam Integer raceId,
                            @RequestParam Integer top1,
                            @RequestParam Integer top2,
                            @RequestParam Integer top3,
                            HttpSession session,
                            Model model) {
        User user = (User) session.getAttribute("loggedInUser");
        if (user == null || !user.getRole().equals("Spectator")) {
            return "redirect:/login";
        }

        try {
            predictionService.createPrediction(user.getId(), raceId, top1, top2, top3);
            return "redirect:/spectator/dashboard";
        } catch (Exception e) {
            model.addAttribute("error", "Không thể tạo dự đoán: " + e.getMessage());
            model.addAttribute("upcomingRaces", raceService.getUpcomingRaces());
            return "spectator-predict";
        }
    }

    @GetMapping("/ranking")
    public String ranking(Model model) {
        model.addAttribute("pageTitle", "Bảng Xếp Hạng");
        model.addAttribute("rankings", predictionService.getGlobalRanking());
        return "spectator-ranking";
    }
}