package com.intelliinvest.server.configuration;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class Mapping {
    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }
}
