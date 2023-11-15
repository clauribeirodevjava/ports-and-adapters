package com.example.palindromos.infra;

import com.example.palindromos.domain.ports.PalavraRepositoryPort;
import com.example.palindromos.domain.ports.PalavraServicePort;
import com.example.palindromos.domain.services.PalavraService;
import com.example.palindromos.domain.services.impl.PalavraServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
    @Bean
    public PalavraServicePort palavraServicePort(PalavraRepositoryPort palavraRepositoryPort) {
        return new PalavraService(palavraRepositoryPort);
    }
}
