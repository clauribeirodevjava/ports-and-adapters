package com.example.palindromos.domain.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.palindromos.adapter.dto.MatrizDTO;
import com.example.palindromos.adapter.dto.PalavraDTO;
import com.example.palindromos.adapter.entities.Palavra;
import com.example.palindromos.domain.ports.PalavraRepositoryPort;
import com.example.palindromos.domain.ports.PalavraServicePort;
@Service
public class PalavraServiceAdapter  implements PalavraServicePort{

    private final PalavraRepositoryPort palavraRepositoryPort;

    public PalavraServiceAdapter(PalavraRepositoryPort palavraRepositoryPort) {
        this.palavraRepositoryPort = palavraRepositoryPort;
    }
    
    public List<Palavra> saveAll(List<PalavraDTO> palavrasDTO) {
        List<Palavra> palavras = palavrasDTO.stream()
                .map(PalavraDTO::toEntity)
                .collect(Collectors.toList());

        return palavraRepositoryPort.savePalavras(palavras);
    }
    
    public List<PalavraDTO> encontrarPalindromos(MatrizDTO entityMatriz) {
        List<PalavraDTO> palindromes = new ArrayList<>();
        char[][] matriz = entityMatriz.getMatriz();

        // Verificar palíndromos nas linhas
        for (int i = 0; i < matriz.length; i++) {
            String rowString = new String(matriz[i]);
            if (isPalindrome(rowString)) {
                palindromes.add(new PalavraDTO(rowString));
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
                palindromes.add(new PalavraDTO(colString));
            }
        }

        // Verificar palíndromos na diagonal principal
        StringBuilder diagonalPrincipalBuilder = new StringBuilder();
        for (int i = 0; i < matriz.length; i++) {
            diagonalPrincipalBuilder.append(matriz[i][i]);
        }
        String diagonalPrincipal = diagonalPrincipalBuilder.toString();
        if (isPalindrome(diagonalPrincipal)) {
            palindromes.add(new PalavraDTO(diagonalPrincipal));
        }

        // Verificar palíndromos na diagonal secundária
        StringBuilder diagonalSecundariaBuilder = new StringBuilder();
        for (int i = 0; i < matriz.length; i++) {
            diagonalSecundariaBuilder.append(matriz[i][matriz.length - 1 - i]);
        }
        String diagonalSecundaria = diagonalSecundariaBuilder.toString();
        if (isPalindrome(diagonalSecundaria)) {
            palindromes.add(new PalavraDTO(diagonalSecundaria));
        } 

        return palindromes;
    }
    private static boolean isPalindrome(String str) {
        String reversed = new StringBuilder(str).reverse().toString();
        return str.equals(reversed);
    }
    
    public List<PalavraDTO> findAllPalavra() {
        List<Palavra> palavras = palavraRepositoryPort.findAllPalavras();
        
        return palavras.stream()
                .map(Palavra::toDTO)
                .collect(Collectors.toList());
    }
}
