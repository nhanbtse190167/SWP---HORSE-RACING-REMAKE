package com.horseracing.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

public class PasswordUtils {
    
    // Mã hóa mật khẩu bằng SHA-256 + Salt
    public static String hashPassword(String password) {
        try {
            // Tạo salt ngẫu nhiên
            SecureRandom random = new SecureRandom();
            byte[] salt = new byte[16];
            random.nextBytes(salt);
            
            // Mã hóa password với salt
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(salt);
            byte[] hashedPassword = md.digest(password.getBytes());
            
            // Kết hợp salt và password đã mã hóa
            byte[] combined = new byte[salt.length + hashedPassword.length];
            System.arraycopy(salt, 0, combined, 0, salt.length);
            System.arraycopy(hashedPassword, 0, combined, salt.length, hashedPassword.length);
            
            // Chuyển sang Base64 để lưu
            return Base64.getEncoder().encodeToString(combined);
            
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    // Kiểm tra mật khẩu nhập vào có khớp với hash không
    public static boolean verifyPassword(String password, String storedHash) {
        try {
            // Giải mã Base64
            byte[] combined = Base64.getDecoder().decode(storedHash);
            
            // Tách salt và hashed password
            byte[] salt = new byte[16];
            byte[] hashedPassword = new byte[combined.length - 16];
            System.arraycopy(combined, 0, salt, 0, 16);
            System.arraycopy(combined, 16, hashedPassword, 0, hashedPassword.length);
            
            // Mã hóa password nhập vào với salt
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(salt);
            byte[] newHashedPassword = md.digest(password.getBytes());
            
            // So sánh
            return MessageDigest.isEqual(hashedPassword, newHashedPassword);
            
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    // Tạo mật khẩu ngẫu nhiên (dùng khi reset password)
    public static String generateRandomPassword(int length) {
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%";
        SecureRandom random = new SecureRandom();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            sb.append(chars.charAt(random.nextInt(chars.length())));
        }
        return sb.toString();
    }
    
    // Test
    public static void main(String[] args) {
        String password = "admin123";
        String hashed = hashPassword(password);
        System.out.println("Password: " + password);
        System.out.println("Hashed: " + hashed);
        System.out.println("Verify: " + verifyPassword(password, hashed));
        System.out.println("Random password: " + generateRandomPassword(10));
    }
}