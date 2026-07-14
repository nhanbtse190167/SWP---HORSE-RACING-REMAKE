package com.se190167.mvc.horseracingtournament.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "admins")
public class Admin extends User {
    // Kế thừa toàn bộ thuộc tính (bao gồm cả @Id) từ class User
}