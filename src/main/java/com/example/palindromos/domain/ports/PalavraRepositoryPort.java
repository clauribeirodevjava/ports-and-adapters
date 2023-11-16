package com.example.palindromos.domain.ports;

import com.example.palindromos.domain.Palavra;

import java.util.List;

public interface PalavraRepositoryPort {

    Palavra savePalavra(Palavra palavra);
    List<Palavra> findAllPalavra();

}