package com.se190167.mvc.horseracingtournament.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "accounts")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String role; // Chứa: ADMIN, JOCKEY, HORSE_OWNER, SPECTATOR

    private String status = "ACTIVE";

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;
}