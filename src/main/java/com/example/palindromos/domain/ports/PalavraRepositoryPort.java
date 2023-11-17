package com.example.palindromos.domain.ports;

import java.util.List;

import com.example.palindromos.adapter.entities.Palavra;

public interface PalavraRepositoryPort {
    List<Palavra> savePalavras(List<Palavra> palavra);
    List<Palavra> findAllPalavras();
}
