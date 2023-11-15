package com.example.palindromos.domain.services;

import com.example.palindromos.adapter.entities.PalavraEntity;
import com.example.palindromos.domain.Palavra;
import com.example.palindromos.domain.ports.PalavraRepositoryPort;
import com.example.palindromos.domain.ports.PalavraServicePort;
import com.example.palindromos.domain.services.impl.PalavraServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

public class PalavraService implements PalavraServicePort {

    private final PalavraRepositoryPort palavraRepositoryPort;

    public List<PalavraEntity> encontrarPalavrasPalindromos(String matriz) {
        return encontrarPalavrasPalindromos(matriz);
    }

    public Iterable<PalavraEntity> listarTodosPalindromos() {
        return null;
    }

    public Optional<PalavraEntity> buscarPorIdPalindromo(Long id) {
        return null;
    }

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
