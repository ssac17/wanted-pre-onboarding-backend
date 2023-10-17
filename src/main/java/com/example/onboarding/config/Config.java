package com.example.onboarding.config;

import com.example.onboarding.dto.NoticeDto;
import com.example.onboarding.model.Notice;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    //ModelMapper
    @Bean
    public ModelMapper modelMapper() {

        ModelMapper modelMapper = new ModelMapper();

        modelMapper.createTypeMap(Notice.class, NoticeDto.class)
                .addMappings(mapper -> {
                    mapper.map(src -> src.getCompany().getCompanyId(), NoticeDto::setCompanyId);
                    mapper.map(src -> src.getCompany().getCompanyName(), NoticeDto::setCompanyName);
                    mapper.map(src -> src.getCompany().getNation(), NoticeDto::setNation);
                    mapper.map(src -> src.getCompany().getRegion(), NoticeDto::setRegion);
                });
        return modelMapper;
    }
}
