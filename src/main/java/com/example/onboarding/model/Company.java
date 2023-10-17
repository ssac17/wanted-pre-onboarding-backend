package com.example.onboarding.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_company")
@Data
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "company_id")
    private Long companyId;
    private String companyName;
    private String nation;
    private String region;

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL)
    private List<Notice> notices = new ArrayList<Notice>();

}
