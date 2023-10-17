package com.example.onboarding.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NoticeDto {

    private Long noticeId;
    private String companyName;
    private String nation;
    private String region;
    private String position;
    private Long compensation;
    private String technology;
    private String content;
    private Long companyId;

}
