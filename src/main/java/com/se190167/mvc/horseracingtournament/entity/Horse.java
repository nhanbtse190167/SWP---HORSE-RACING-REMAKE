package com.se190167.mvc.horseracingtournament.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "horses")
public class Horse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String name;

    private String breed;
    private Integer age;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private HorseOwner owner;

    private String status = "ACTIVE";
}