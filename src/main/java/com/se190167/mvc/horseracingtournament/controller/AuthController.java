package com.se190167.mvc.horseracingtournament.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthController {

    // 1. Hiển thị trang đăng nhập
    @GetMapping("/login")
    public String showLoginPage() {
        // Trả về file login.html trong thư mục templates
        return "login";
    }

    // 2. Hứng dữ liệu từ Form đăng nhập đẩy lên
    @PostMapping("/login")
    public String processLogin(@RequestParam("identifier") String identifier,
                               @RequestParam("password") String password) {

        // TODO: Chúng ta sẽ viết logic kiểm tra tài khoản với Database ở đây sau.
        // Tạm thời, khi submit form, hệ thống sẽ tự động chuyển hướng (redirect) về trang chủ

        return "redirect:/";
    }

    // 3. Chuẩn bị sẵn đường dẫn cho trang Đăng ký (sẽ làm sau)
    @GetMapping("/register")
    public String showRegisterPage() {
        return "Register";
    }
}