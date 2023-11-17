package com.example.palindromos.infra;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
    /*
    @Bean
    public PalavraServicePort palavraServicePort(PalavraRepositoryPort palavraRepositoryPort) {
        return new PalavraService(palavraRepositoryPort);
    }
    */
}
