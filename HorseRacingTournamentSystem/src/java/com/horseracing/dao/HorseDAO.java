package com.horseracing.dao;

import com.horseracing.model.Horse;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HorseDAO {
    
    private Connection conn;
    
    public HorseDAO() {
        this.conn = DBConnection.getConnection();
    }
    
    // Lấy tất cả ngựa
    public List<Horse> getAllHorses() {
        List<Horse> horses = new ArrayList<>();
        String sql = "SELECT * FROM horses ORDER BY id";
        
        try (PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            
            while (rs.next()) {
                Horse horse = new Horse();
                horse.setId(rs.getInt("id"));
                horse.setOwnerId(rs.getInt("owner_id"));
                horse.setHorseCode(rs.getString("horse_code"));
                horse.setRfid(rs.getString("rfid"));
                horse.setName(rs.getString("name"));
                horse.setBreed(rs.getString("breed"));
                horse.setColor(rs.getString("color"));
                horse.setGender(rs.getString("gender"));
                horse.setDateOfBirth(rs.getDate("date_of_birth"));
                horse.setWeight(rs.getDouble("weight"));
                horse.setHeight(rs.getDouble("height"));
                horse.setOriginCountry(rs.getString("origin_country"));
                horse.setHealthStatus(rs.getString("health_status"));
                horse.setEligible(rs.getBoolean("is_eligible"));
                horse.setActive(rs.getBoolean("is_active"));
                horse.setRetiredDate(rs.getDate("retired_date"));
                horse.setCreatedAt(rs.getTimestamp("created_at"));
                horse.setUpdatedAt(rs.getTimestamp("updated_at"));
                horse.setCreatedBy(rs.getInt("created_by"));
                horses.add(horse);
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return horses;
    }
    
    // Lấy ngựa theo Owner ID
    public List<Horse> getHorsesByOwnerId(int ownerId) {
        List<Horse> horses = new ArrayList<>();
        String sql = "SELECT * FROM horses WHERE owner_id = ? ORDER BY id";
        
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, ownerId);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                Horse horse = new Horse();
                horse.setId(rs.getInt("id"));
                horse.setOwnerId(rs.getInt("owner_id"));
                horse.setHorseCode(rs.getString("horse_code"));
                horse.setRfid(rs.getString("rfid"));
                horse.setName(rs.getString("name"));
                horse.setBreed(rs.getString("breed"));
                horse.setColor(rs.getString("color"));
                horse.setGender(rs.getString("gender"));
                horse.setDateOfBirth(rs.getDate("date_of_birth"));
                horse.setWeight(rs.getDouble("weight"));
                horse.setHeight(rs.getDouble("height"));
                horse.setOriginCountry(rs.getString("origin_country"));
                horse.setHealthStatus(rs.getString("health_status"));
                horse.setEligible(rs.getBoolean("is_eligible"));
                horse.setActive(rs.getBoolean("is_active"));
                horse.setRetiredDate(rs.getDate("retired_date"));
                horse.setCreatedAt(rs.getTimestamp("created_at"));
                horse.setUpdatedAt(rs.getTimestamp("updated_at"));
                horse.setCreatedBy(rs.getInt("created_by"));
                horses.add(horse);
            }
            rs.close();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return horses;
    }
    
    // Lấy ngựa theo ID
    public Horse getHorseById(int id) {
        Horse horse = null;
        String sql = "SELECT * FROM horses WHERE id = ?";
        
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                horse = new Horse();
                horse.setId(rs.getInt("id"));
                horse.setOwnerId(rs.getInt("owner_id"));
                horse.setHorseCode(rs.getString("horse_code"));
                horse.setRfid(rs.getString("rfid"));
                horse.setName(rs.getString("name"));
                horse.setBreed(rs.getString("breed"));
                horse.setColor(rs.getString("color"));
                horse.setGender(rs.getString("gender"));
                horse.setDateOfBirth(rs.getDate("date_of_birth"));
                horse.setWeight(rs.getDouble("weight"));
                horse.setHeight(rs.getDouble("height"));
                horse.setOriginCountry(rs.getString("origin_country"));
                horse.setHealthStatus(rs.getString("health_status"));
                horse.setEligible(rs.getBoolean("is_eligible"));
                horse.setActive(rs.getBoolean("is_active"));
                horse.setRetiredDate(rs.getDate("retired_date"));
                horse.setCreatedAt(rs.getTimestamp("created_at"));
                horse.setUpdatedAt(rs.getTimestamp("updated_at"));
                horse.setCreatedBy(rs.getInt("created_by"));
            }
            rs.close();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return horse;
    }
    
    // Thêm ngựa mới
    public boolean addHorse(Horse horse) {
        String sql = "INSERT INTO horses (owner_id, horse_code, rfid, name, breed, color, gender, " +
                     "date_of_birth, weight, height, origin_country, health_status, is_eligible, is_active, created_by) " +
                     "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, horse.getOwnerId());
            ps.setString(2, horse.getHorseCode());
            ps.setString(3, horse.getRfid());
            ps.setString(4, horse.getName());
            ps.setString(5, horse.getBreed());
            ps.setString(6, horse.getColor());
            ps.setString(7, horse.getGender());
            ps.setDate(8, new java.sql.Date(horse.getDateOfBirth().getTime()));
            ps.setDouble(9, horse.getWeight());
            ps.setDouble(10, horse.getHeight());
            ps.setString(11, horse.getOriginCountry());
            ps.setString(12, horse.getHealthStatus());
            ps.setBoolean(13, horse.isEligible());
            ps.setBoolean(14, horse.isActive());
            ps.setInt(15, horse.getCreatedBy());
            
            int rows = ps.executeUpdate();
            return rows > 0;
            
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    // Cập nhật ngựa
    public boolean updateHorse(Horse horse) {
        String sql = "UPDATE horses SET name = ?, breed = ?, color = ?, weight = ?, height = ?, " +
                     "health_status = ?, is_eligible = ?, is_active = ?, updated_at = GETDATE() WHERE id = ?";
        
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, horse.getName());
            ps.setString(2, horse.getBreed());
            ps.setString(3, horse.getColor());
            ps.setDouble(4, horse.getWeight());
            ps.setDouble(5, horse.getHeight());
            ps.setString(6, horse.getHealthStatus());
            ps.setBoolean(7, horse.isEligible());
            ps.setBoolean(8, horse.isActive());
            ps.setInt(9, horse.getId());
            
            int rows = ps.executeUpdate();
            return rows > 0;
            
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    // Xóa ngựa
    public boolean deleteHorse(int id) {
        String sql = "DELETE FROM horses WHERE id = ?";
        
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            int rows = ps.executeUpdate();
            return rows > 0;
            
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}