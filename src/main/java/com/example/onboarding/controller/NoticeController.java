package com.example.onboarding.controller;

import com.example.onboarding.dto.NoticeDto;
import com.example.onboarding.model.Notice;
import com.example.onboarding.service.NoticeService;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/recruit")
public class NoticeController {

    private final NoticeService noticeService;
    private final ModelMapper modelMapper;

    public NoticeController(NoticeService noticeService, ModelMapper modelMapper) {
        this.noticeService = noticeService;
        this.modelMapper = modelMapper;
    }

    @PostMapping( "/register")
    public Map<String, NoticeDto> register(@RequestBody NoticeDto noticeDto) {

        NoticeDto savedNotice = noticeService.registerNotice(noticeDto);

        return Map.of("savedNotice", savedNotice);
    }

    @GetMapping("/{noticeNo}")
    public NoticeDto get(@PathVariable(name = "noticeNo") Long noticeId) {

        return noticeService.getNotice(noticeId);
    }

    @PutMapping("/{noticeNo}")
    public Map<String, NoticeDto> update(@PathVariable(name = "noticeNo") Long noticeId, @RequestBody NoticeDto noticeDto) {

        Notice updatedNotice = noticeService.updateNotice(noticeId, noticeDto);
        NoticeDto updatedNoticeDto = modelMapper.map(updatedNotice, NoticeDto.class);

        return Map.of("updatedNotice", updatedNoticeDto);
    }

    @DeleteMapping("/{noticeNo}")
    public String delete(@PathVariable(name = "noticeNo") Long noticeId) {

         noticeService.deleteNotice(noticeId);
         String msg = "SUCCESS " + noticeId;

         return msg;
    }

    @GetMapping("/list/")
    public List<NoticeDto> list() {

        return noticeService.getListNotice();
    }
}
