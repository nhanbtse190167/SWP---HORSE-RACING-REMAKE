package com.se190167.mvc.horseracingtournament.controller;

import com.se190167.mvc.horseracingtournament.entity.*;
import com.se190167.mvc.horseracingtournament.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/owner")
public class HorseOwnerController {

    @Autowired
    private HorseService horseService;

    @Autowired
    private RaceService raceService;

    @Autowired
    private UserService userService;

    @GetMapping("/dashboard")
    public String dashboard(Model model, HttpSession session) {
        User user = (User) session.getAttribute("loggedInUser");
        if (user == null || !user.getRole().equals("Horse Owner")) {
            return "redirect:/login";
        }

        List<Horse> myHorses = horseService.getHorsesByOwnerId(user.getId());

        model.addAttribute("pageTitle", "Dashboard Chủ Ngựa");
        model.addAttribute("totalHorses", myHorses.size());
        model.addAttribute("totalRaces", raceService.getRacesForOwner(user.getId()).size());
        model.addAttribute("totalWins", raceService.getWinsForOwner(user.getId()));
        model.addAttribute("myHorses", myHorses);

        return "owner-dashboard";
    }

    @GetMapping("/horses")
    public String myHorses(Model model, HttpSession session) {
        User user = (User) session.getAttribute("loggedInUser");
        if (user == null || !user.getRole().equals("Horse Owner")) {
            return "redirect:/login";
        }

        model.addAttribute("pageTitle", "Danh Sách Ngựa Của Tôi");
        model.addAttribute("horses", horseService.getHorsesByOwnerId(user.getId()));
        return "owner-horses";
    }

    @GetMapping("/horses/add")
    public String addHorseForm(Model model, HttpSession session) {
        User user = (User) session.getAttribute("loggedInUser");
        if (user == null || !user.getRole().equals("Horse Owner")) {
            return "redirect:/login";
        }

        model.addAttribute("pageTitle", "Thêm Ngựa Mới");
        model.addAttribute("horse", new Horse());
        return "owner-horse-add";
    }

    @PostMapping("/horses/add")
    public String addHorse(@ModelAttribute Horse horse, HttpSession session) {
        User user = (User) session.getAttribute("loggedInUser");
        horse.setOwner(userService.getUserById(user.getId()).get().getHorseOwner());
        horseService.createHorse(horse);
        return "redirect:/owner/horses";
    }

    @GetMapping("/results")
    public String raceResults(Model model, HttpSession session) {
        User user = (User) session.getAttribute("loggedInUser");
        if (user == null || !user.getRole().equals("Horse Owner")) {
            return "redirect:/login";
        }

        model.addAttribute("pageTitle", "Kết Quả Đua");
        model.addAttribute("results", raceService.getResultsForOwner(user.getId()));
        return "owner-results";
    }
}