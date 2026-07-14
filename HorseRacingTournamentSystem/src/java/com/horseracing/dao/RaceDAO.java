package com.horseracing.dao;

import com.horseracing.model.Race;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RaceDAO {

    private Connection conn;

    public RaceDAO() {
        this.conn = DBConnection.getConnection();
    }

    // Lấy tất cả cuộc đua
    public List<Race> getAllRaces() {
        List<Race> races = new ArrayList<>();
        String sql = "SELECT * FROM races ORDER BY id";

        try (PreparedStatement ps = conn.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Race race = new Race();
                race.setId(rs.getInt("id"));
                race.setRaceCode(rs.getString("race_code"));
                race.setRaceName(rs.getString("race_name"));
                race.setRaceType(rs.getString("race_type"));
                race.setDistance(rs.getInt("distance"));
                race.setWeightRequirement(rs.getDouble("weight_requirement"));
                race.setMinAge(rs.getInt("min_age"));
                race.setMaxAge(rs.getInt("max_age"));
                race.setPrizeMoney(rs.getDouble("prize_money"));
                race.setRaceDate(rs.getDate("race_date"));
                race.setRaceTime(rs.getString("race_time"));
                race.setVenue(rs.getString("venue"));
                race.setTrackCondition(rs.getString("track_condition"));
                race.setWeatherForecast(rs.getString("weather_forecast"));
                race.setMaxParticipants(rs.getInt("max_participants"));
                race.setMinParticipants(rs.getInt("min_participants"));
                race.setStatus(rs.getString("status"));
                race.setResultDeclared(rs.getBoolean("result_declared"));
                race.setResultDeclaredAt(rs.getTimestamp("result_declared_at"));
                race.setCreatedAt(rs.getTimestamp("created_at"));
                race.setUpdatedAt(rs.getTimestamp("updated_at"));
                race.setCreatedBy(rs.getInt("created_by"));
                race.setApprovedBy(rs.getInt("approved_by"));
                race.setApprovedAt(rs.getTimestamp("approved_at"));
                races.add(race);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return races;
    }

    // Lấy cuộc đua theo ID
    public Race getRaceById(int id) {
        Race race = null;
        String sql = "SELECT * FROM races WHERE id = ?";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                race = new Race();
                race.setId(rs.getInt("id"));
                race.setRaceCode(rs.getString("race_code"));
                race.setRaceName(rs.getString("race_name"));
                race.setRaceType(rs.getString("race_type"));
                race.setDistance(rs.getInt("distance"));
                race.setWeightRequirement(rs.getDouble("weight_requirement"));
                race.setMinAge(rs.getInt("min_age"));
                race.setMaxAge(rs.getInt("max_age"));
                race.setPrizeMoney(rs.getDouble("prize_money"));
                race.setRaceDate(rs.getDate("race_date"));
                race.setRaceTime(rs.getString("race_time"));
                race.setVenue(rs.getString("venue"));
                race.setTrackCondition(rs.getString("track_condition"));
                race.setWeatherForecast(rs.getString("weather_forecast"));
                race.setMaxParticipants(rs.getInt("max_participants"));
                race.setMinParticipants(rs.getInt("min_participants"));
                race.setStatus(rs.getString("status"));
                race.setResultDeclared(rs.getBoolean("result_declared"));
                race.setResultDeclaredAt(rs.getTimestamp("result_declared_at"));
                race.setCreatedAt(rs.getTimestamp("created_at"));
                race.setUpdatedAt(rs.getTimestamp("updated_at"));
                race.setCreatedBy(rs.getInt("created_by"));
                race.setApprovedBy(rs.getInt("approved_by"));
                race.setApprovedAt(rs.getTimestamp("approved_at"));
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return race;
    }

    // Thêm cuộc đua mới
    public boolean addRace(Race race) {
        String sql = "INSERT INTO races (race_code, race_name, race_type, distance, weight_requirement, "
                + "min_age, max_age, prize_money, race_date, race_time, venue, track_condition, "
                + "weather_forecast, max_participants, min_participants, status, created_by) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, race.getRaceCode());
            ps.setString(2, race.getRaceName());
            ps.setString(3, race.getRaceType());
            ps.setInt(4, race.getDistance());
            ps.setDouble(5, race.getWeightRequirement());
            ps.setInt(6, race.getMinAge());
            ps.setInt(7, race.getMaxAge());
            ps.setDouble(8, race.getPrizeMoney());
            ps.setDate(9, new java.sql.Date(race.getRaceDate().getTime()));
            ps.setString(10, race.getRaceTime());
            ps.setString(11, race.getVenue());
            ps.setString(12, race.getTrackCondition());
            ps.setString(13, race.getWeatherForecast());
            ps.setInt(14, race.getMaxParticipants());
            ps.setInt(15, race.getMinParticipants());
            ps.setString(16, race.getStatus());
            ps.setInt(17, race.getCreatedBy());

            int rows = ps.executeUpdate();
            return rows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Cập nhật trạng thái cuộc đua
    public boolean updateRaceStatus(int raceId, String status) {
        String sql = "UPDATE races SET status = ?, updated_at = GETDATE() WHERE id = ?";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, status);
            ps.setInt(2, raceId);
            int rows = ps.executeUpdate();
            return rows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}