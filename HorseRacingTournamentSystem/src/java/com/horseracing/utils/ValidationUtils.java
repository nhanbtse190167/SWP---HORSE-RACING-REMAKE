package com.horseracing.utils;

import java.util.regex.Pattern;

public class ValidationUtils {
    
    // Kiểm tra email hợp lệ
    public static boolean isValidEmail(String email) {
        if (email == null || email.trim().isEmpty()) {
            return false;
        }
        String regex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
        return Pattern.matches(regex, email);
    }
    
    // Kiểm tra số điện thoại (Việt Nam)
    public static boolean isValidPhone(String phone) {
        if (phone == null || phone.trim().isEmpty()) {
            return true; // Cho phép bỏ trống
        }
        String regex = "^(0|\\+84)[0-9]{9,10}$";
        return Pattern.matches(regex, phone);
    }
    
    // Kiểm tra username hợp lệ (chỉ chữ và số, không dấu)
    public static boolean isValidUsername(String username) {
        if (username == null || username.trim().isEmpty()) {
            return false;
        }
        String regex = "^[a-zA-Z0-9_]{3,20}$";
        return Pattern.matches(regex, username);
    }
    
    // Kiểm tra mật khẩu (ít nhất 6 ký tự)
    public static boolean isValidPassword(String password) {
        return password != null && password.length() >= 6;
    }
    
    // Kiểm tra tên (không chứa số)
    public static boolean isValidName(String name) {
        if (name == null || name.trim().isEmpty()) {
            return false;
        }
        String regex = "^[\\p{L} ]{2,50}$";
        return Pattern.matches(regex, name);
    }
    
    // Kiểm tra mã code (ví dụ: HOR001, JOC001)
    public static boolean isValidCode(String code) {
        if (code == null || code.trim().isEmpty()) {
            return false;
        }
        String regex = "^[A-Z]{3}[0-9]{3}$";
        return Pattern.matches(regex, code.toUpperCase());
    }
    
    // Kiểm tra số dương
    public static boolean isPositiveNumber(double value) {
        return value > 0;
    }
    
    // Kiểm tra số nguyên dương
    public static boolean isPositiveInteger(int value) {
        return value > 0;
    }
    
    // Kiểm tra ngày tháng hợp lệ (không quá xa)
    public static boolean isValidDate(java.util.Date date) {
        if (date == null) return false;
        java.util.Date now = new java.util.Date();
        // Không cho phép ngày trong tương lai
        return !date.after(now);
    }
    
    // Test
    public static void main(String[] args) {
        System.out.println("Email: " + isValidEmail("test@email.com")); // true
        System.out.println("Phone: " + isValidPhone("0901234567")); // true
        System.out.println("Username: " + isValidUsername("admin_123")); // true
        System.out.println("Password: " + isValidPassword("admin123")); // true
        System.out.println("Name: " + isValidName("Nguyễn Văn A")); // true
        System.out.println("Code: " + isValidCode("HOR001")); // true
    }
}