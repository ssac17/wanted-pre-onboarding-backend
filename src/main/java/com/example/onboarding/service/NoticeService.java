package com.example.onboarding.service;

import com.example.onboarding.dto.NoticeDto;
import com.example.onboarding.model.Notice;

import java.util.List;


public interface NoticeService {

    NoticeDto registerNotice(NoticeDto noticeDto);

    NoticeDto getNotice(Long noticeId);

    Notice updateNotice(Long noticeId, NoticeDto noticeDto);

    void deleteNotice(Long noticeId);

    List<NoticeDto> getListNotice();
}
