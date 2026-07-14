package com.se190167.mvc.horseracingtournament.controller;

import com.se190167.mvc.horseracingtournament.entity.*;
import com.se190167.mvc.horseracingtournament.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/jockey")
public class JockeyController {

    @Autowired
    private RaceService raceService;

    @Autowired
    private UserService userService;

    @GetMapping("/dashboard")
    public String dashboard(Model model, HttpSession session) {
        User user = (User) session.getAttribute("loggedInUser");
        if (user == null || !user.getRole().equals("Jockey")) {
            return "redirect:/login";
        }

        model.addAttribute("pageTitle", "Dashboard Kỵ Sĩ");
        model.addAttribute("upcomingRaces", raceService.getUpcomingRacesForJockey(user.getId()));
        model.addAttribute("totalRaces", raceService.getRacesForJockey(user.getId()).size());
        model.addAttribute("totalWins", raceService.getWinsForJockey(user.getId()));
        model.addAttribute("totalPoints", raceService.getPointsForJockey(user.getId()));
        model.addAttribute("jockeyInfo", user);

        return "jockey-dashboard";
    }

    @GetMapping("/schedule")
    public String schedule(Model model, HttpSession session) {
        User user = (User) session.getAttribute("loggedInUser");
        if (user == null || !user.getRole().equals("Jockey")) {
            return "redirect:/login";
        }

        model.addAttribute("pageTitle", "Lịch Đua Của Tôi");
        model.addAttribute("races", raceService.getRacesForJockey(user.getId()));
        return "jockey-schedule";
    }

    @GetMapping("/profile")
    public String profile(Model model, HttpSession session) {
        User user = (User) session.getAttribute("loggedInUser");
        if (user == null || !user.getRole().equals("Jockey")) {
            return "redirect:/login";
        }

        model.addAttribute("pageTitle", "Thông Tin Cá Nhân");
        model.addAttribute("jockey", user);
        return "jockey-profile";
    }
}