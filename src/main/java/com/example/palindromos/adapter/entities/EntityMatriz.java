package com.example.palindromos.adapter.entities;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EntityMatriz {
    @JsonProperty("matriz")
    private char[][] matriz;

    public EntityMatriz() {
    }

    public EntityMatriz(char[][] matriz) {
        this.matriz = matriz;
    }

    public char[][] getMatriz() {
        return matriz;
    }

    public void setMatriz(char[][] matriz) {
        this.matriz = matriz;
    }
}
