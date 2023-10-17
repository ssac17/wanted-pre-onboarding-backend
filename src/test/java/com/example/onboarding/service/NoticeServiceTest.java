package com.example.onboarding.service;

import com.example.onboarding.dto.NoticeDto;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class NoticeServiceTest {

    @Autowired
    private NoticeService noticeService;

    @Test
    public void testRegister() {
        NoticeDto noticeDto = NoticeDto.builder()
                .position("프론트엔드")
                .compensation(1000000L)
                .content("아무거나")
                .technology("React")
                .build();

        NoticeDto noticeId = noticeService.registerNotice(noticeDto);
        System.out.println(noticeId);
    }

    @Test
    public void testGet() {
        Long noticeId = 2L;

        System.out.println(noticeService.getNotice(noticeId));
    }

    @Test
    public void testUpdate() {
        Long noticeId = 2L;

        NoticeDto noticeDto = noticeService.getNotice(noticeId);

        noticeDto.setPosition("DBA");
        noticeDto.setCompensation(2000000L);
        noticeDto.setContent("오세요");
        noticeDto.setTechnology("oracle");

        noticeService.updateNotice(noticeId, noticeDto);

        System.out.println(noticeService.getNotice(noticeId));
    }

    @Test
    public void testDelete() {
        long noticeId = 2L;
        noticeService.deleteNotice(noticeId);
    }

//    @Test
//    public void getList() {
//        System.out.println(noticeService.getListNotice());
//    }
}