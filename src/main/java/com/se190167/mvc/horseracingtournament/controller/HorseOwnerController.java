package com.se190167.mvc.horseracingtournament.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/owner")
public class HorseOwnerController {

    @GetMapping("/dashboard")
    public String showOwnerDashboard() {
        return "owner-dashboard"; // Yêu cầu có file owner-dashboard.html trong thư mục templates
    }
}