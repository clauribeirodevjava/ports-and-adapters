package com.example.palindromos.domain.services;

import com.example.palindromos.domain.Palavra;
import com.example.palindromos.domain.ports.PalavraRepositoryPort;
import com.example.palindromos.domain.ports.PalavraServicePort;
import org.springframework.stereotype.Service;

import java.util.List;
public class PalavraService implements PalavraServicePort {

    private final PalavraRepositoryPort palavraRepositoryPort;

    public PalavraService(PalavraRepositoryPort palavraRepositoryPort) {
        this.palavraRepositoryPort = palavraRepositoryPort;
    }

    @Override
    public Palavra savePalavra(Palavra palavra) {
        return palavraRepositoryPort.savePalavra(palavra);
    }

    @Override
    public List<Palavra> findAllPalavra() {
        return palavraRepositoryPort.findAllPalavra();
    }
}
