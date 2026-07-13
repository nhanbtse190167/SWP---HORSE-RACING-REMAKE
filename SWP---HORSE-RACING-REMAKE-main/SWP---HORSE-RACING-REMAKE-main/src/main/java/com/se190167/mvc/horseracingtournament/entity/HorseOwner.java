package com.se190167.mvc.horseracingtournament.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "horse_owners")
public class HorseOwner {
    @Id
    @Column(name = "user_id")
    private Integer userId;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    @JoinColumn(name = "user_id")
    private User user;

    @Column(length = 500)
    private String address;

    @Column(columnDefinition = "NVARCHAR(MAX)")
    private String note;

    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Horse> horses;

    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<RaceEntry> raceEntries;

    // Getters and Setters
    public Integer getUserId() { return userId; }
    public void setUserId(Integer userId) { this.userId = userId; }

    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public String getNote() { return note; }
    public void setNote(String note) { this.note = note; }

    public List<Horse> getHorses() { return horses; }
    public void setHorses(List<Horse> horses) { this.horses = horses; }

    public List<RaceEntry> getRaceEntries() { return raceEntries; }
    public void setRaceEntries(List<RaceEntry> raceEntries) { this.raceEntries = raceEntries; }
}