package com.example.palindromos.adapter.dto;

public class MatrizDTO {
    private char[][] matriz;


    public MatrizDTO() {
    }

    public MatrizDTO(char[][] matriz) {
        this.matriz = matriz;
    }

    public char[][] getMatriz() {
        return matriz;
    }

    public void setMatriz(char[][] matriz) {
        this.matriz = matriz;
    }
}
