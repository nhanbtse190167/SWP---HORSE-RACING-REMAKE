package com.se190167.mvc.horseracingtournament.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/referee")
public class RefereeController {

    @GetMapping("/dashboard")
    public String showRefereeDashboard() {
        return "referee-dashboard"; // Yêu cầu file referee-dashboard.html
    }
}