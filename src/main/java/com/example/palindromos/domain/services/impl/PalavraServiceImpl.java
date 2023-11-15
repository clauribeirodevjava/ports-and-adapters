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

    private static List<PalavraEntity> palavrasPalindromo = new ArrayList<>();
    public PalavraServiceImpl(PalavraRepositoryPort palavraRepositoryPort) {
        super(palavraRepositoryPort);
    }
    public static void main(String[] args) {
        // Exemplo de matriz em formato JSON
        String jsonMatrix = "[[\"A\",\"O\",\"S\",\"S\",\"O\"],[\"Y\",\"R\",\"Z\",\"X\",\"L\"],[\"J\",\"S\",\"A\",\"P\",\"M\"],[\"J\",\"K\",\"P\",\"R\",\"Z\"],[\"Y\",\"L\",\"E\",\"R\",\"A\"]]";

        // Converter a string JSON para matriz de caracteres
        char[][] matrix = new Gson.(jsonMatrix, char[][].class);

        // Encontrar e exibir palíndromos na matriz
        encontrarPalindromos(matrix);
    }

    public static void encontrarPalindromos(char[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        // Verificar palíndromos nas linhas horizontais
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                checkPalindrome(matrix, i, j, i, j + 1); // Horizontal
                checkPalindrome(matrix, i, j, i + 1, j); // Vertical
                checkPalindrome(matrix, i, j, i + 1, j + 1); // Diagonal
                checkPalindrome(matrix, i, j, i - 1, j + 1); // Diagonal inversa
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
