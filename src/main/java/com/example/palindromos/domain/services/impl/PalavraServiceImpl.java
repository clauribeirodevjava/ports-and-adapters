package com.example.palindromos.domain.services.impl;

import org.springframework.stereotype.Service;

import com.example.palindromos.domain.ports.PalavraRepositoryPort;
import com.example.palindromos.domain.services.PalavraService;

@Service
public class PalavraServiceImpl extends PalavraService {

    public PalavraServiceImpl(PalavraRepositoryPort palavraRepositoryPort) {
        super(palavraRepositoryPort);
    }
}

