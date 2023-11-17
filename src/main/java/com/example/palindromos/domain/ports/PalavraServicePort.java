package com.example.palindromos.domain.ports;

import java.util.List;

import com.example.palindromos.adapter.dto.MatrizDTO;
import com.example.palindromos.adapter.dto.PalavraDTO;
import com.example.palindromos.adapter.entities.Palavra;

public interface PalavraServicePort {
    List<PalavraDTO> encontrarPalindromos(MatrizDTO entityMatriz);
    List<Palavra> saveAll(List<PalavraDTO> palavrasDTO);
    List<PalavraDTO> findAllPalavra();
}
