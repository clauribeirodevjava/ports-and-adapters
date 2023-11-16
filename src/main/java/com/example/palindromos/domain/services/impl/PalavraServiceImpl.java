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

    public String encontrarPalindromos(EntityMatriz entityMatriz) {
        char[][] matriz = entityMatriz.getMatriz();
        StringBuilder result = new StringBuilder();

        // Encontrar palíndromos nas linhas horizontais
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                checkPalindrome(result, matriz, i, j, i, j + 1); // Horizontal
                checkPalindrome(result, matriz, i, j, i + 1, j); // Vertical
                checkPalindrome(result, matriz, i, j, i + 1, j + 1); // Diagonal
                checkPalindrome(result, matriz, i, j, i - 1, j + 1); // Diagonal inversa
            }
        }
        return result.toString();
    }

    private void checkPalindrome(StringBuilder result, char[][] matriz, int startRow, int startCol, int endRow, int endCol) {
        int rows = matriz.length;
        int cols = matriz[0].length;

        StringBuilder palindrome = new StringBuilder();

        while (startRow >= 0 && startRow < rows && startCol >= 0 && startCol < cols) {
            palindrome.append(matriz[startRow][startCol]);

            if (isPalindrome(palindrome.toString())) {
                result.append("Encontrado palíndromo: ").append(palindrome).append("\n");
            }

            startRow += endRow > startRow ? 1 : (endRow < startRow ? -1 : 0);
            startCol += endCol > startCol ? 1 : (endCol < startCol ? -1 : 0);
        }
    }

    private boolean isPalindrome(String str) {
        return str.equals(new StringBuilder(str).reverse().toString());
    }


    public static void encontrarPalindromos(char[][] matriz) {
        int rows = matriz.length;
        int cols = matriz[0].length;

        // Verificar palíndromos nas linhas horizontais
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                checkPalindrome(matriz, i, j, i, j + 1); // Horizontal
                checkPalindrome(matriz, i, j, i + 1, j); // Vertical
                checkPalindrome(matriz, i, j, i + 1, j + 1); // Diagonal
                checkPalindrome(matriz, i, j, i - 1, j + 1); // Diagonal inversa
            }
        }
    }

    private static void checkPalindrome(char[][] matrix, int startRow, int startCol, int endRow, int endCol) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        StringBuilder palindrome = new StringBuilder();

        while (startRow >= 0 && startRow < rows && startCol >= 0 && startCol < cols) {
            palindrome.append(matrix[startRow][startCol]);

            if (eUmPalindrome(palindrome.toString())) {
                System.out.println("Encontrado palíndromo: " + palindrome);
            }

            startRow += endRow > startRow ? 1 : (endRow < startRow ? -1 : 0);
            startCol += endCol > startCol ? 1 : (endCol < startCol ? -1 : 0);
        }
    }

    private static boolean eUmPalindrome(String str) {
        return str.equals(new StringBuilder(str).reverse().toString());
    }
}
