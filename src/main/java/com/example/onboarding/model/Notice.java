package com.example.onboarding.model;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Table(name = "tb_notice")
@Data
public class Notice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "notice_id")
    private Long noticeId;

    @ManyToOne(fetch=FetchType.LAZY, optional=false)
    @JoinColumn(name="company_id", nullable=false)
    private Company company;

    private String position;
    private Long compensation;
    private String content;
    private String technology;

}
