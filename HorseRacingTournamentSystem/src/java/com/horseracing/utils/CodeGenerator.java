package com.horseracing.utils;

import com.horseracing.dao.HorseDAO;
import com.horseracing.dao.JockeyDAO;
import com.horseracing.dao.RaceDAO;
import com.horseracing.model.Horse;
import com.horseracing.model.Jockey;
import com.horseracing.model.Race;

import java.util.List;

public class CodeGenerator {
    
    private static HorseDAO horseDAO = new HorseDAO();
    private static JockeyDAO jockeyDAO = new JockeyDAO();
    private static RaceDAO raceDAO = new RaceDAO();
    
    // Tạo mã cho Ngựa (HORXXX)
    public static String generateHorseCode() {
        List<Horse> horses = horseDAO.getAllHorses();
        int count = horses.size() + 1;
        return "HOR" + String.format("%03d", count);
    }
    
    // Tạo mã cho Kỵ sỹ (JOCXXX)
    public static String generateJockeyCode() {
        List<Jockey> jockeys = jockeyDAO.getAllJockeys();
        int count = jockeys.size() + 1;
        return "JOC" + String.format("%03d", count);
    }
    
    // Tạo mã cho Cuộc đua (RACXXX)
    public static String generateRaceCode() {
        List<Race> races = raceDAO.getAllRaces();
        int count = races.size() + 1;
        return "RAC" + String.format("%03d", count);
    }
    
    // Tạo mã đăng ký (REGYYYYMMDDXXXX)
    public static String generateRegistrationCode() {
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyyMMdd");
        String datePart = sdf.format(new java.util.Date());
        String randomPart = String.format("%04d", (int) (Math.random() * 10000));
        return "REG" + datePart + randomPart;
    }
    
    // Tạo mã lời mời (INVYYYYMMDDXXXX)
    public static String generateInvitationCode() {
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyyMMdd");
        String datePart = sdf.format(new java.util.Date());
        String randomPart = String.format("%04d", (int) (Math.random() * 10000));
        return "INV" + datePart + randomPart;
    }
    
    // Tạo mã thành tích (ACHYYYYMMDDXXXX)
    public static String generateAchievementCode() {
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyyMMdd");
        String datePart = sdf.format(new java.util.Date());
        String randomPart = String.format("%04d", (int) (Math.random() * 10000));
        return "ACH" + datePart + randomPart;
    }
    
    // Test
    public static void main(String[] args) {
        System.out.println("Mã ngựa: " + generateHorseCode());
        System.out.println("Mã kỵ sỹ: " + generateJockeyCode());
        System.out.println("Mã cuộc đua: " + generateRaceCode());
        System.out.println("Mã đăng ký: " + generateRegistrationCode());
        System.out.println("Mã lời mời: " + generateInvitationCode());
        System.out.println("Mã thành tích: " + generateAchievementCode());
    }
}