package com.se190167.mvc.horseracingtournament.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/jockey")
public class JockeyController {

    @GetMapping("/dashboard")
    public String showJockeyDashboard() {
        return "jockey-dashboard"; // Yêu cầu có file jockey-dashboard.html trong thư mục templates
    }
}