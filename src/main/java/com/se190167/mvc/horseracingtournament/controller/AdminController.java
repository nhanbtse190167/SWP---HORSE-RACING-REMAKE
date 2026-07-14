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
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private UserService userService;

    @Autowired
    private HorseService horseService;

    @Autowired
    private TournamentService tournamentService;

    @Autowired
    private RaceService raceService;

    // ===================== DASHBOARD =====================
    @GetMapping("/dashboard")
    public String dashboard(Model model, HttpSession session) {
        User user = (User) session.getAttribute("loggedInUser");
        if (user == null || !user.getRole().equals("Admin")) {
            return "redirect:/login";
        }

        model.addAttribute("pageTitle", "Admin Dashboard");
        model.addAttribute("totalHorses", horseService.getAllHorses().size());
        model.addAttribute("totalJockeys", userService.getUsersByRole("Jockey").size());
        model.addAttribute("totalUsers", userService.getAllUsers().size());
        model.addAttribute("totalTournaments", tournamentService.getAllTournaments().size());
        model.addAttribute("totalRaces", raceService.getAllRaces().size());
        model.addAttribute("recentUsers", userService.getRecentUsers(5));
        model.addAttribute("recentHorses", horseService.getRecentHorses(5));

        return "admin-dashboard";
    }

    // ===================== HORSE MANAGEMENT =====================
    @GetMapping("/horses")
    public String manageHorses(Model model, HttpSession session) {
        User user = (User) session.getAttribute("loggedInUser");
        if (user == null || !user.getRole().equals("Admin")) {
            return "redirect:/login";
        }

        model.addAttribute("pageTitle", "Quản lý Ngựa Đua");
        model.addAttribute("horses", horseService.getAllHorses());
        return "admin-horses";
    }

    @GetMapping("/horses/add")
    public String addHorseForm(Model model, HttpSession session) {
        User user = (User) session.getAttribute("loggedInUser");
        if (user == null || !user.getRole().equals("Admin")) {
            return "redirect:/login";
        }

        model.addAttribute("pageTitle", "Thêm Ngựa Mới");
        model.addAttribute("horse", new Horse());
        model.addAttribute("owners", userService.getUsersByRole("Horse Owner"));
        return "admin-horse-add";
    }

    @PostMapping("/horses/add")
    public String addHorse(@ModelAttribute Horse horse, Model model) {
        horseService.createHorse(horse);
        return "redirect:/admin/horses";
    }

    @GetMapping("/horses/edit/{id}")
    public String editHorseForm(@PathVariable Integer id, Model model, HttpSession session) {
        User user = (User) session.getAttribute("loggedInUser");
        if (user == null || !user.getRole().equals("Admin")) {
            return "redirect:/login";
        }

        model.addAttribute("pageTitle", "Sửa Thông Tin Ngựa");
        model.addAttribute("horse", horseService.getHorseById(id).orElse(null));
        model.addAttribute("owners", userService.getUsersByRole("Horse Owner"));
        return "admin-horse-edit";
    }

    @PostMapping("/horses/update")
    public String updateHorse(@ModelAttribute Horse horse) {
        horseService.updateHorse(horse);
        return "redirect:/admin/horses";
    }

    @GetMapping("/horses/delete/{id}")
    public String deleteHorse(@PathVariable Integer id) {
        horseService.deleteHorse(id);
        return "redirect:/admin/horses";
    }

    // ===================== TOURNAMENT MANAGEMENT =====================
    @GetMapping("/tournaments")
    public String manageTournaments(Model model, HttpSession session) {
        User user = (User) session.getAttribute("loggedInUser");
        if (user == null || !user.getRole().equals("Admin")) {
            return "redirect:/login";
        }

        model.addAttribute("pageTitle", "Quản lý Giải Đấu");
        model.addAttribute("tournaments", tournamentService.getAllTournaments());
        return "admin-tournaments";
    }

    @GetMapping("/tournaments/add")
    public String addTournamentForm(Model model, HttpSession session) {
        User user = (User) session.getAttribute("loggedInUser");
        if (user == null || !user.getRole().equals("Admin")) {
            return "redirect:/login";
        }

        model.addAttribute("pageTitle", "Tạo Giải Đấu Mới");
        model.addAttribute("tournament", new Tournament());
        return "admin-tournament-add";
    }

    @PostMapping("/tournaments/add")
    public String addTournament(@ModelAttribute Tournament tournament) {
        tournamentService.createTournament(tournament);
        return "redirect:/admin/tournaments";
    }

    // ===================== USER MANAGEMENT =====================
    @GetMapping("/users")
    public String manageUsers(Model model, HttpSession session) {
        User user = (User) session.getAttribute("loggedInUser");
        if (user == null || !user.getRole().equals("Admin")) {
            return "redirect:/login";
        }

        model.addAttribute("pageTitle", "Quản lý Người Dùng");
        model.addAttribute("users", userService.getAllUsers());
        return "admin-users";
    }

    @GetMapping("/users/status/{id}")
    public String toggleUserStatus(@PathVariable Integer id) {
        userService.toggleUserStatus(id);
        return "redirect:/admin/users";
    }

    @GetMapping("/users/delete/{id}")
    public String deleteUser(@PathVariable Integer id) {
        userService.deleteUser(id);
        return "redirect:/admin/users";
    }
}