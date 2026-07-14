package com.se190167.mvc.horseracingtournament.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "violations")
public class Violation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    // Lượt thi đấu và người vi phạm (Jockey/Ngựa)
    @ManyToOne
    @JoinColumn(name = "race_entry_id", nullable = false)
    private RaceEntry raceEntry;

    // Trọng tài lập biên bản
    @ManyToOne
    @JoinColumn(name = "referee_id", nullable = false)
    private Referee referee;

    // Liên kết với bảng Cấu hình phạt (PenaltyRule) để biết mức phạt
    @ManyToOne
    @JoinColumn(name = "penalty_rule_id", nullable = false)
    private PenaltyRule penaltyRule;

    // Mô tả chi tiết hành vi (VD: Cố tình chèn ép lane số 3)
    @Column(columnDefinition = "NVARCHAR(MAX)")
    private String description;

    @Column(name = "violation_time")
    private LocalDateTime violationTime = LocalDateTime.now();

    // Trạng thái xử lý: PENDING (Chờ duyệt), APPLIED (Đã áp dụng phạt), REJECTED (Hủy bỏ)
    private String status = "APPLIED";
}