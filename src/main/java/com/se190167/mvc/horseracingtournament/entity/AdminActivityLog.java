package com.se190167.mvc.horseracingtournament.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "admin_activity_logs")
public class AdminActivityLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "admin_id")
    private Admin admin;

    private String action; // Ví dụ: Xóa ngựa, Cập nhật giải đấu
    private String details;

    @Column(name = "timestamp")
    private LocalDateTime timestamp = LocalDateTime.now();
}