package com.se190167.mvc.horseracingtournament.controller;

import com.se190167.mvc.horseracingtournament.entity.Account;
import com.se190167.mvc.horseracingtournament.entity.User;
import com.se190167.mvc.horseracingtournament.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.HttpSession;
import java.util.Optional;

@Controller
public class AuthController {

    @Autowired
    private AccountService accountService;

    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("pageTitle", "Đăng Nhập");
        return "login";
    }

    @PostMapping("/login")
    public String doLogin(@RequestParam String username,
                          @RequestParam String password,
                          @RequestParam(defaultValue = "spectator") String role,
                          HttpSession session,
                          Model model) {

        // Bước 1: Tìm account theo username
        Optional<Account> accountOpt = accountService.getAccountByUsername(username);

        if (accountOpt.isEmpty()) {
            model.addAttribute("error", "❌ Tên đăng nhập không tồn tại!");
            return "login";
        }

        Account account = accountOpt.get();

        // Bước 2: Kiểm tra mật khẩu
        if (!password.equals(account.getPassword())) {
            model.addAttribute("error", "❌ Mật khẩu không đúng!");
            return "login";
        }

        // Bước 3: Lấy user từ account
        User user = account.getUser();

        if (user == null) {
            model.addAttribute("error", "❌ Tài khoản không có thông tin người dùng!");
            return "login";
        }

        // Bước 4: Kiểm tra trạng thái user
        if (!"active".equals(user.getStatus())) {
            model.addAttribute("error", "❌ Tài khoản đã bị khóa!");
            return "login";
        }

        // Bước 5: Kiểm tra role
        if (!user.getRole().equalsIgnoreCase(role)) {
            model.addAttribute("error", "❌ Vai trò không khớp! Bạn là: " + user.getRole());
            return "login";
        }

        // Bước 6: Lưu vào session
        session.setAttribute("loggedInUser", user);

        // Bước 7: Chuyển hướng theo role
        switch (role.toLowerCase()) {
            case "admin":
                return "redirect:/admin/dashboard";
            case "horse owner":
                return "redirect:/owner/dashboard";
            case "jockey":
                return "redirect:/jockey/dashboard";
            case "referee":
                return "redirect:/referee/dashboard";
            case "spectator":
            default:
                return "redirect:/";
        }
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }
}