package com.example.onboarding.service;

import com.example.onboarding.dto.NoticeDto;
import com.example.onboarding.model.Company;
import com.example.onboarding.model.Notice;
import com.example.onboarding.repository.CompanyRepository;
import com.example.onboarding.repository.NoticeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class NoticeServiceImpl implements NoticeService {

    private final NoticeRepository noticeRepository;
    private final CompanyRepository companyRepository;
    private final ModelMapper modelMapper;


    public NoticeServiceImpl(ModelMapper modelMapper, NoticeRepository noticeRepository, CompanyRepository companyRepository) {
        this.modelMapper = modelMapper;
        this.noticeRepository = noticeRepository;
        this.companyRepository = companyRepository;
    }

    @Override
    public NoticeDto registerNotice(NoticeDto noticeDto) {

        Notice notice = modelMapper.map(noticeDto, Notice.class);

        Optional<Company> company = companyRepository.findById(noticeDto.getCompanyId());
        notice.setCompany(company.orElseThrow());
        Notice savedNotice = noticeRepository.save(notice);

        return modelMapper.map(savedNotice, NoticeDto.class);

    }

    @Override
    public NoticeDto getNotice(Long noticeId) {

        Optional<Notice> notice = noticeRepository.findById(noticeId);
        Notice getNotice = notice.orElseThrow();
        NoticeDto noticeDto = modelMapper.map(getNotice, NoticeDto.class);

        return noticeDto;
    }

    @Override
    public Notice updateNotice(Long noticeId, NoticeDto noticeDto) {

        Optional<Notice> notice = noticeRepository.findById(noticeId);
        Notice updateNotice = notice.orElseThrow();

        updateNotice.setPosition(noticeDto.getPosition());
        updateNotice.setCompensation(noticeDto.getCompensation());
        updateNotice.setContent(noticeDto.getContent());
        updateNotice.setTechnology(noticeDto.getTechnology());

        return noticeRepository.save(updateNotice);
    }

    @Override
    public void deleteNotice(Long noticeId) {
        noticeRepository.deleteById(noticeId);
    }

    @Override
    public List<NoticeDto> getListNotice() {
        List<Notice> noticeList = noticeRepository.findAll();
        return noticeList.stream()
                .map(notice -> modelMapper.map(notice, NoticeDto.class))
                .collect(Collectors.toList());
    }
}
