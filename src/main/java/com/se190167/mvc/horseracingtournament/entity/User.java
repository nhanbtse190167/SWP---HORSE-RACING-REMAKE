package com.se190167.mvc.horseracingtournament.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "full_name", nullable = false, length = 255)
    private String fullName;

    @Column(unique = true, nullable = false, length = 255)
    private String email;

    @Column(length = 20)
    private String phone;

    @Column(length = 50)
    private String role;

    @Column(length = 50)
    private String status;

    // ❌ XÓA field password (không cần nữa)

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Account account;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Admin admin;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private HorseOwner horseOwner;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Jockey jockey;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Referee referee;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Spectator spectator;

    @OneToMany(mappedBy = "receiverUser", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Notification> notifications;

    // Getters (không có getPassword)
    public Integer getId() { return id; }
    public String getFullName() { return fullName; }
    public String getEmail() { return email; }
    public String getPhone() { return phone; }
    public String getRole() { return role; }
    public String getStatus() { return status; }
    public Account getAccount() { return account; }
    public Admin getAdmin() { return admin; }
    public HorseOwner getHorseOwner() { return horseOwner; }
    public Jockey getJockey() { return jockey; }
    public Referee getReferee() { return referee; }
    public Spectator getSpectator() { return spectator; }
    public List<Notification> getNotifications() { return notifications; }

    // Setters (không có setPassword)
    public void setId(Integer id) { this.id = id; }
    public void setFullName(String fullName) { this.fullName = fullName; }
    public void setEmail(String email) { this.email = email; }
    public void setPhone(String phone) { this.phone = phone; }
    public void setRole(String role) { this.role = role; }
    public void setStatus(String status) { this.status = status; }
    public void setAccount(Account account) { this.account = account; }
    public void setAdmin(Admin admin) { this.admin = admin; }
    public void setHorseOwner(HorseOwner horseOwner) { this.horseOwner = horseOwner; }
    public void setJockey(Jockey jockey) { this.jockey = jockey; }
    public void setReferee(Referee referee) { this.referee = referee; }
    public void setSpectator(Spectator spectator) { this.spectator = spectator; }
    public void setNotifications(List<Notification> notifications) { this.notifications = notifications; }
}