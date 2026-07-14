package com.se190167.mvc.horseracingtournament.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/spectator")
public class SpectatorController {

    @GetMapping("/dashboard")
    public String showSpectatorDashboard() {
        return "spectator-dashboard";
    }
}