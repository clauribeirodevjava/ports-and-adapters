package com.example.palindromos.adapter.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.example.palindromos.adapter.dto.MatrizDTO;
import com.example.palindromos.adapter.dto.PalavraDTO;

public interface PalavraControllerInterface {
    ResponseEntity<List<PalavraDTO>> encontrarPalindromos(MatrizDTO entityMatriz);
    List<PalavraDTO> findAllPalavra();
}