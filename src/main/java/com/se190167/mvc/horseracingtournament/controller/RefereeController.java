package com.se190167.mvc.horseracingtournament.controller;

import com.se190167.mvc.horseracingtournament.entity.*;
import com.se190167.mvc.horseracingtournament.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/referee")
public class RefereeController {

    @Autowired
    private RaceService raceService;

    @Autowired
    private ViolationService violationService;

    @GetMapping("/dashboard")
    public String dashboard(Model model, HttpSession session) {
        User user = (User) session.getAttribute("loggedInUser");
        if (user == null || !user.getRole().equals("Referee")) {
            return "redirect:/login";
        }

        model.addAttribute("pageTitle", "Dashboard Trọng Tài");
        model.addAttribute("pendingResults", raceService.getPendingResults());
        model.addAttribute("pendingViolations", violationService.getPendingViolations());
        model.addAttribute("todayRaces", raceService.getTodayRaces());

        return "referee-dashboard";
    }

    @GetMapping("/results")
    public String manageResults(Model model, HttpSession session) {
        User user = (User) session.getAttribute("loggedInUser");
        if (user == null || !user.getRole().equals("Referee")) {
            return "redirect:/login";
        }

        model.addAttribute("pageTitle", "Quản Lý Kết Quả");
        model.addAttribute("results", raceService.getAllResults());
        return "referee-results";
    }

    @GetMapping("/violations")
    public String manageViolations(Model model, HttpSession session) {
        User user = (User) session.getAttribute("loggedInUser");
        if (user == null || !user.getRole().equals("Referee")) {
            return "redirect:/login";
        }

        model.addAttribute("pageTitle", "Quản Lý Vi Phạm");
        model.addAttribute("violations", violationService.getAllViolations());
        return "referee-violations";
    }
}