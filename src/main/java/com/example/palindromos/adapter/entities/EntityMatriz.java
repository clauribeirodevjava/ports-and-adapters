package com.example.palindromos.adapter.entities;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class EntityMatriz {
    private char[][] matriz;
    private List<String> palindromosEncontrados;

    public EntityMatriz(char[][] matriz, List<String> palindromosEncontrados) {
        this.matriz = matriz;
        this.palindromosEncontrados = palindromosEncontrados;
    }

    public char[][] getMatriz() {
        return matriz;
    }

    public List<String> getPalindromosEncontrados() {
        return palindromosEncontrados;
    }
}
