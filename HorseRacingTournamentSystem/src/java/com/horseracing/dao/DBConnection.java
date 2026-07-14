package com.horseracing.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    
    // Thông tin kết nối SQL Server (dùng sqljdbc4.jar)
    private static final String URL = "jdbc:sqlserver://localhost:1433;databaseName=horse_racing;encrypt=false;";
    private static final String USER = "sa";
    private static final String PASSWORD = "12345"; // Thay bằng password của bạn
    
    private static Connection connection = null;
    
    // ⭐ PHƯƠNG THỨC getConnection() - PHẢI LÀ PUBLIC STATIC
    public static Connection getConnection() {
        if (connection == null) {
            try {
                // Load driver SQL Server (cách cũ cho sqljdbc4.jar)
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                connection = DriverManager.getConnection(URL, USER, PASSWORD);
                System.out.println("Kết nối SQL Server thành công!");
            } catch (ClassNotFoundException e) {
                System.err.println("Không tìm thấy driver SQL Server! Kiểm tra file sqljdbc4.jar trong lib");
                e.printStackTrace();
            } catch (SQLException e) {
                System.err.println("Kết nối SQL Server thất bại!");
                e.printStackTrace();
            }
        }
        return connection;
    }
    
    // Đóng kết nối
    public static void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
                connection = null;
                System.out.println("Đã đóng kết nối!");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    
    // Test kết nối
    public static void main(String[] args) {
        Connection conn = DBConnection.getConnection();
        if (conn != null) {
            System.out.println("Kết nối thành công đến database: horse_racing");
        } else {
            System.err.println("Kết nối thất bại!");
        }
        DBConnection.closeConnection();
    }
}