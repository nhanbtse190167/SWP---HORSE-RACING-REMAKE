package com.se190167.mvc.horseracingtournament.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "horses")
public class Horse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner_id")
    private HorseOwner owner;

    @Column(nullable = false, length = 255)
    private String name;

    @Column(length = 100)
    private String breed;

    private Integer age;

    private Double weight;

    @Column(columnDefinition = "NVARCHAR(MAX)")
    private String achievement;

    @Column(name = "vaccination_certificate", length = 255)
    private String vaccinationCertificate;

    @OneToMany(mappedBy = "horse", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<RaceEntry> raceEntries;

    // Getters
    public Integer getId() { return id; }
    public HorseOwner getOwner() { return owner; }
    public String getName() { return name; }
    public String getBreed() { return breed; }
    public Integer getAge() { return age; }
    public Double getWeight() { return weight; }
    public String getAchievement() { return achievement; }
    public String getVaccinationCertificate() { return vaccinationCertificate; }
    public List<RaceEntry> getRaceEntries() { return raceEntries; }

    // Setters
    public void setId(Integer id) { this.id = id; }
    public void setOwner(HorseOwner owner) { this.owner = owner; }
    public void setName(String name) { this.name = name; }
    public void setBreed(String breed) { this.breed = breed; }
    public void setAge(Integer age) { this.age = age; }
    public void setWeight(Double weight) { this.weight = weight; }
    public void setAchievement(String achievement) { this.achievement = achievement; }
    public void setVaccinationCertificate(String vaccinationCertificate) { this.vaccinationCertificate = vaccinationCertificate; }
    public void setRaceEntries(List<RaceEntry> raceEntries) { this.raceEntries = raceEntries; }
}