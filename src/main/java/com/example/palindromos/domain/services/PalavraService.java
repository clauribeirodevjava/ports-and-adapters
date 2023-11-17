package com.example.palindromos.domain.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.example.palindromos.adapter.entities.EntityMatriz;
import com.example.palindromos.adapter.entities.PalavraEntity;
import com.example.palindromos.domain.Palavra;
import com.example.palindromos.domain.ports.PalavraRepositoryPort;

public class PalavraService  {

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
    
    
    public List<Palavra> saveAll(List<Palavra> palavras) {
    	return palavraRepositoryPort.saveAll(palavras);	
    }
    
    public List<Palavra> encontrarPalindromos(EntityMatriz entityMatriz) {
        List<Palavra> palindromes = new ArrayList<>();
        char[][] matriz = entityMatriz.getMatriz();

        // Verificar palíndromos nas linhas
        for (int i = 0; i < matriz.length; i++) {
            String rowString = new String(matriz[i]);
            if (isPalindrome(rowString)) {
                palindromes.add(new Palavra(rowString, true));
            } else {
                palindromes.add(new Palavra(rowString, false));
            }
        }

        // Verificar palíndromos nas colunas
        for (int col = 0; col < matriz[0].length; col++) {
            StringBuilder colStringBuilder = new StringBuilder();
            for (int row = 0; row < matriz.length; row++) {
                colStringBuilder.append(matriz[row][col]);
            }
            String colString = colStringBuilder.toString();
            if (isPalindrome(colString)) {
                palindromes.add(new Palavra(colString, true));
            } else {
                palindromes.add(new Palavra(colString, false));
            }
        }

        // Verificar palíndromos na diagonal principal
        StringBuilder diagonalPrincipalBuilder = new StringBuilder();
        for (int i = 0; i < matriz.length; i++) {
            diagonalPrincipalBuilder.append(matriz[i][i]);
        }
        String diagonalPrincipal = diagonalPrincipalBuilder.toString();
        if (isPalindrome(diagonalPrincipal)) {
            palindromes.add(new Palavra(diagonalPrincipal, true));
        } else {
            palindromes.add(new Palavra(diagonalPrincipal, false));
        }

        // Verificar palíndromos na diagonal secundária
        StringBuilder diagonalSecundariaBuilder = new StringBuilder();
        for (int i = 0; i < matriz.length; i++) {
            diagonalSecundariaBuilder.append(matriz[i][matriz.length - 1 - i]);
        }
        String diagonalSecundaria = diagonalSecundariaBuilder.toString();
        if (isPalindrome(diagonalSecundaria)) {
            palindromes.add(new Palavra(diagonalSecundaria, true));
        } else {
            palindromes.add(new Palavra(diagonalSecundaria, false));
        }

        return palindromes;
    }
    private static boolean isPalindrome(String str) {
        String reversed = new StringBuilder(str).reverse().toString();
        return str.equals(reversed);
    }
    
/*
    @Override
    public Palavra savePalavra(Palavra palavra) {
        return palavraRepositoryPort.savePalavra(palavra);
    }

    @Override
    public List<Palavra> findAllPalavra() {
        return palavraRepositoryPort.findAllPalavra();
    }
    */
}
