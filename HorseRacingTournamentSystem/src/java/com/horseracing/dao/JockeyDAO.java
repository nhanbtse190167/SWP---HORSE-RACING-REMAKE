package com.horseracing.dao;

import com.horseracing.model.Jockey;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JockeyDAO {

    private Connection conn;

    public JockeyDAO() {
        this.conn = DBConnection.getConnection();
    }

    // Lấy tất cả kỵ sỹ
    public List<Jockey> getAllJockeys() {
        List<Jockey> jockeys = new ArrayList<>();
        String sql = "SELECT * FROM jockeys ORDER BY id";

        try (PreparedStatement ps = conn.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Jockey jockey = new Jockey();
                jockey.setId(rs.getInt("id"));
                jockey.setUserId(rs.getInt("user_id"));
                jockey.setJockeyCode(rs.getString("jockey_code"));
                jockey.setWeight(rs.getDouble("weight"));
                jockey.setHeight(rs.getDouble("height"));
                jockey.setDateOfBirth(rs.getDate("date_of_birth"));
                jockey.setNationality(rs.getString("nationality"));
                jockey.setExperienceYears(rs.getInt("experience_years"));
                jockey.setTournamentsWon(rs.getInt("tournaments_won"));
                jockey.setCertificateUrl(rs.getString("certificate_url"));
                jockey.setCertificateVerified(rs.getBoolean("certificate_verified"));
                jockey.setCertificateVerifiedAt(rs.getTimestamp("certificate_verified_at"));
                jockey.setHealthStatus(rs.getString("health_status"));
                jockey.setMedicalExpiryDate(rs.getDate("medical_expiry_date"));
                jockey.setRating(rs.getDouble("rating"));
                jockey.setEligible(rs.getBoolean("is_eligible"));
                jockey.setCreatedAt(rs.getTimestamp("created_at"));
                jockey.setUpdatedAt(rs.getTimestamp("updated_at"));
                jockeys.add(jockey);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return jockeys;
    }

    // Lấy kỵ sỹ theo ID
    public Jockey getJockeyById(int id) {
        Jockey jockey = null;
        String sql = "SELECT * FROM jockeys WHERE id = ?";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                jockey = new Jockey();
                jockey.setId(rs.getInt("id"));
                jockey.setUserId(rs.getInt("user_id"));
                jockey.setJockeyCode(rs.getString("jockey_code"));
                jockey.setWeight(rs.getDouble("weight"));
                jockey.setHeight(rs.getDouble("height"));
                jockey.setDateOfBirth(rs.getDate("date_of_birth"));
                jockey.setNationality(rs.getString("nationality"));
                jockey.setExperienceYears(rs.getInt("experience_years"));
                jockey.setTournamentsWon(rs.getInt("tournaments_won"));
                jockey.setCertificateUrl(rs.getString("certificate_url"));
                jockey.setCertificateVerified(rs.getBoolean("certificate_verified"));
                jockey.setCertificateVerifiedAt(rs.getTimestamp("certificate_verified_at"));
                jockey.setHealthStatus(rs.getString("health_status"));
                jockey.setMedicalExpiryDate(rs.getDate("medical_expiry_date"));
                jockey.setRating(rs.getDouble("rating"));
                jockey.setEligible(rs.getBoolean("is_eligible"));
                jockey.setCreatedAt(rs.getTimestamp("created_at"));
                jockey.setUpdatedAt(rs.getTimestamp("updated_at"));
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return jockey;
    }

    // Lấy kỵ sỹ theo User ID
    public Jockey getJockeyByUserId(int userId) {
        Jockey jockey = null;
        String sql = "SELECT * FROM jockeys WHERE user_id = ?";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, userId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                jockey = new Jockey();
                jockey.setId(rs.getInt("id"));
                jockey.setUserId(rs.getInt("user_id"));
                jockey.setJockeyCode(rs.getString("jockey_code"));
                jockey.setWeight(rs.getDouble("weight"));
                jockey.setHeight(rs.getDouble("height"));
                jockey.setDateOfBirth(rs.getDate("date_of_birth"));
                jockey.setNationality(rs.getString("nationality"));
                jockey.setExperienceYears(rs.getInt("experience_years"));
                jockey.setTournamentsWon(rs.getInt("tournaments_won"));
                jockey.setCertificateUrl(rs.getString("certificate_url"));
                jockey.setCertificateVerified(rs.getBoolean("certificate_verified"));
                jockey.setCertificateVerifiedAt(rs.getTimestamp("certificate_verified_at"));
                jockey.setHealthStatus(rs.getString("health_status"));
                jockey.setMedicalExpiryDate(rs.getDate("medical_expiry_date"));
                jockey.setRating(rs.getDouble("rating"));
                jockey.setEligible(rs.getBoolean("is_eligible"));
                jockey.setCreatedAt(rs.getTimestamp("created_at"));
                jockey.setUpdatedAt(rs.getTimestamp("updated_at"));
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return jockey;
    }

    // Thêm kỵ sỹ mới
    public boolean addJockey(Jockey jockey) {
        String sql = "INSERT INTO jockeys (user_id, jockey_code, weight, height, date_of_birth, nationality, "
                + "experience_years, tournaments_won, certificate_url, certificate_verified, "
                + "certificate_verified_at, health_status, medical_expiry_date, rating, is_eligible) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, jockey.getUserId());
            ps.setString(2, jockey.getJockeyCode());
            ps.setDouble(3, jockey.getWeight());
            ps.setDouble(4, jockey.getHeight());
            ps.setDate(5, new java.sql.Date(jockey.getDateOfBirth().getTime()));
            ps.setString(6, jockey.getNationality());
            ps.setInt(7, jockey.getExperienceYears());
            ps.setInt(8, jockey.getTournamentsWon());
            ps.setString(9, jockey.getCertificateUrl());
            ps.setBoolean(10, jockey.isCertificateVerified());
            ps.setTimestamp(11, new java.sql.Timestamp(jockey.getCertificateVerifiedAt().getTime()));
            ps.setString(12, jockey.getHealthStatus());
            ps.setDate(13, new java.sql.Date(jockey.getMedicalExpiryDate().getTime()));
            ps.setDouble(14, jockey.getRating());
            ps.setBoolean(15, jockey.isEligible());

            int rows = ps.executeUpdate();
            return rows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}