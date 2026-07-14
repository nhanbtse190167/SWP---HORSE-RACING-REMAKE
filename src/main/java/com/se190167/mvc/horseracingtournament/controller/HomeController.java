package com.se190167.mvc.horseracingtournament.controller;

import com.se190167.mvc.horseracingtournament.entity.User;
import com.se190167.mvc.horseracingtournament.service.TournamentService;
import com.se190167.mvc.horseracingtournament.service.RaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpSession;

@Controller
public class HomeController {

    @Autowired
    private TournamentService tournamentService;

    @Autowired
    private RaceService raceService;

    @GetMapping("/")
    public String home(Model model, HttpSession session) {
        User loggedInUser = (User) session.getAttribute("loggedInUser");
        if (loggedInUser != null) {
            model.addAttribute("userName", loggedInUser.getFullName());
            model.addAttribute("userRole", loggedInUser.getRole());
        }

        model.addAttribute("upcomingRaces", raceService.getUpcomingRaces());
        model.addAttribute("activeTournaments", tournamentService.getActiveTournaments());
        model.addAttribute("totalHorses", 1492);
        model.addAttribute("totalJockeys", 348);
        model.addAttribute("totalRaces", 42);

        return "index";
    }
}