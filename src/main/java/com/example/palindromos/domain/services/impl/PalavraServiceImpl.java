package com.example.palindromos.domain.services.impl;

import com.example.palindromos.adapter.entities.EntityMatriz;
import com.example.palindromos.adapter.entities.PalavraEntity;
import com.example.palindromos.adapter.repository.PalavraRepository;
import com.example.palindromos.domain.ports.PalavraRepositoryPort;
import com.example.palindromos.domain.ports.PalavraServicePort;
import com.example.palindromos.domain.services.PalavraService;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PalavraServiceImpl extends PalavraService {

    private PalavraRepository palavraRepository;
    private PalavraServicePort palavraServicePort;
    private EntityMatriz entityMatriz;

    private static List<PalavraEntity> palavrasPalindromo = new ArrayList<>();
    public PalavraServiceImpl(PalavraRepositoryPort palavraRepositoryPort) {
        super(palavraRepositoryPort);
    }
    
    public  List<String> encontrarPalindromos(EntityMatriz entityMatriz) {
        List<String> palindromes = new ArrayList<>();
        char[][] matriz = entityMatriz.getMatriz();

        // Verificar palíndromos nas linhas
        for (char[] row : matriz) {
            String rowString = new String(row);
            if (isPalindrome(rowString)) {
                palindromes.add(rowString);
            }
        }

        // Verificar palíndromos nas colunas
        for (int col = 0; col < matriz[0].length; col++) {
            StringBuilder colStringBuilder = new StringBuilder();
            for (char[] row : matriz) {
                colStringBuilder.append(row[col]);
            }
            String colString = colStringBuilder.toString();
            if (isPalindrome(colString)) {
                palindromes.add(colString);
            }
        }

        // Verificar palíndromos na diagonal principal
        StringBuilder diagonalPrincipalBuilder = new StringBuilder();
        for (int i = 0; i < matriz.length; i++) {
            diagonalPrincipalBuilder.append(matriz[i][i]);
        }
        String diagonalPrincipal = diagonalPrincipalBuilder.toString();
        if (isPalindrome(diagonalPrincipal)) {
            palindromes.add(diagonalPrincipal);
        }

        // Verificar palíndromos na diagonal secundária
        StringBuilder diagonalSecundariaBuilder = new StringBuilder();
        for (int i = 0; i < matriz.length; i++) {
            diagonalSecundariaBuilder.append(matriz[i][matriz.length - 1 - i]);
        }
        String diagonalSecundaria = diagonalSecundariaBuilder.toString();
        if (isPalindrome(diagonalSecundaria)) {
            palindromes.add(diagonalSecundaria);
        }

        return palindromes;
    }

    private static boolean isPalindrome(String str) {
        String reversed = new StringBuilder(str).reverse().toString();
        return str.equals(reversed);
    }
}

