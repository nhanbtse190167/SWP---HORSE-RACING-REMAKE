package com.horseracing.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtils {
    
    private static final String DATE_FORMAT = "dd/MM/yyyy";
    private static final String TIME_FORMAT = "HH:mm:ss";
    private static final String DATETIME_FORMAT = "dd/MM/yyyy HH:mm:ss";
    
    // Chuyển Date sang String
    public static String dateToString(Date date) {
        if (date == null) return "";
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
        return sdf.format(date);
    }
    
    public static String timeToString(Date date) {
        if (date == null) return "";
        SimpleDateFormat sdf = new SimpleDateFormat(TIME_FORMAT);
        return sdf.format(date);
    }
    
    public static String dateTimeToString(Date date) {
        if (date == null) return "";
        SimpleDateFormat sdf = new SimpleDateFormat(DATETIME_FORMAT);
        return sdf.format(date);
    }
    
    // Chuyển String sang Date
    public static Date stringToDate(String dateStr) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
            return sdf.parse(dateStr);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public static Date stringToDateTime(String dateTimeStr) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(DATETIME_FORMAT);
            return sdf.parse(dateTimeStr);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    // Tính tuổi từ ngày sinh
    public static int calculateAge(Date birthDate) {
        if (birthDate == null) return 0;
        Calendar today = Calendar.getInstance();
        Calendar birth = Calendar.getInstance();
        birth.setTime(birthDate);
        
        int age = today.get(Calendar.YEAR) - birth.get(Calendar.YEAR);
        if (today.get(Calendar.MONTH) < birth.get(Calendar.MONTH) ||
            (today.get(Calendar.MONTH) == birth.get(Calendar.MONTH) &&
             today.get(Calendar.DAY_OF_MONTH) < birth.get(Calendar.DAY_OF_MONTH))) {
            age--;
        }
        return age;
    }
    
    // Cộng thêm ngày
    public static Date addDays(Date date, int days) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DAY_OF_MONTH, days);
        return cal.getTime();
    }
    
    // So sánh ngày (không tính giờ)
    public static boolean isSameDay(Date date1, Date date2) {
        if (date1 == null || date2 == null) return false;
        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(date1);
        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(date2);
        return cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR) &&
               cal1.get(Calendar.MONTH) == cal2.get(Calendar.MONTH) &&
               cal1.get(Calendar.DAY_OF_MONTH) == cal2.get(Calendar.DAY_OF_MONTH);
    }
    
    // Kiểm tra ngày trong quá khứ
    public static boolean isPastDate(Date date) {
        if (date == null) return false;
        return date.before(new Date());
    }
    
    // Test
    public static void main(String[] args) {
        Date now = new Date();
        System.out.println("Date: " + dateToString(now));
        System.out.println("Time: " + timeToString(now));
        System.out.println("DateTime: " + dateTimeToString(now));
        System.out.println("Age: " + calculateAge(stringToDate("01/01/2000")));
    }
}