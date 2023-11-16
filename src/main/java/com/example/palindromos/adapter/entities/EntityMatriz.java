package com.example.palindromos.adapter.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.json.JSONObject;

import java.util.List;

public class EntityMatriz {
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
