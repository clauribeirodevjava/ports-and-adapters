package com.example.palindromos.domain.services.impl;

import com.example.palindromos.adapter.repository.PalavraRepository;
import com.example.palindromos.domain.Palavra;
import com.example.palindromos.domain.ports.PalavraRepositoryPort;
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

    @Autowired
    private PalavraRepository palavraRepository;

    private static List<Palavra> palavrasPalindromo = new ArrayList<>();

    public PalavraServiceImpl(PalavraRepositoryPort palavraRepositoryPort) {
        super(palavraRepositoryPort);
    }

    public List<Palavra> encontrarPalavrasPalindromos(String jsonMatriz) {

        try {
            JSONObject jsonObj = new JSONObject(jsonMatriz);

            JSONArray matrizJson = jsonObj.getJSONArray("matriz");
            int numRows = matrizJson.length();

            if (numRows > 10) {
                System.out.println("O número de linhas excede o máximo de 10.");
                return null;
            }

            char[][] matriz = new char[numRows][];
            int numCols = 0;

            for (int i = 0; i < numRows; i++) {
                JSONArray row = matrizJson.getJSONArray(i);
                int currentCols = row.length();
                if (currentCols > 10) {
                    System.out.println("O número de colunas na linha " + i + " excede o máximo de 10.");
                    return null;
                }
                if (numCols == 0) {
                    numCols = currentCols;
                } else if (numCols != currentCols) {
                    System.out.println("A matriz não é quadrada. O número de colunas na linha " + i
                            + " é diferente das linhas anteriores.");
                    return null;
                }
                matriz[i] = new char[currentCols];
                for (int j = 0; j < currentCols; j++) {
                    matriz[i][j] = row.getString(j).charAt(0);
                }
            }
            encontrarPalindromosNaMatriz(matriz);

            return salvarPalindromos(palavrasPalindromo);
        } catch (Exception e) {
            System.out.println("Erro ao analisar o JSON: " + e.getMessage());
            return null;
        }
    }

    public List<Palavra> encontrarPalindromosNaMatriz(char[][] matriz) {
        int numLinhas = matriz.length;
        int numCols = matriz[0].length;
        for (int linha = 0; linha < numLinhas; linha++) {
            for (int coluna = 0; coluna < numCols; coluna++) {
                // Horizontal (esquerda para direita)
                for (int len = 1; coluna + len <= numCols; len++) {
                    String palavraHorizontal = new String(matriz[linha], coluna, len);
                    if (eUmPalindromo(palavraHorizontal)) {
                        Palavra encontradoPalindromo = new Palavra();
                        encontradoPalindromo.setDescricao(palavraHorizontal);
                        inserirPalindromoNaLista(palavraHorizontal);
                    }
                }

                // Vertical (cima para baixo)
                for (int len = 1; linha + len <= numLinhas; len++) {
                    StringBuilder palavraVertical = new StringBuilder();
                    for (int i = 0; i < len; i++) {
                        palavraVertical.append(matriz[linha + i][coluna]);
                    }
                    if (eUmPalindromo(palavraVertical.toString())) {
                        inserirPalindromoNaLista(palavraVertical.toString());
                    }
                }


                // Diagonal (cima-esquerda para baixo-direita)
                for (int len = 1; linha + len <= numLinhas && coluna + len <= numCols; len++) {
                    StringBuilder palavraDiagonal = new StringBuilder();
                    for (int i = 0; i < len; i++) {
                        palavraDiagonal.append(matriz[linha + i][coluna + i]);
                    }
                    if (eUmPalindromo(palavraDiagonal.toString())) {
                        inserirPalindromoNaLista(palavraDiagonal.toString());
                    }
                }

                // Diagonal (cima-direita para baixo-esquerda)
                for (int len = 1; linha + len <= numLinhas && coluna - len >= 0; len++) {
                    StringBuilder palavraDiagonal = new StringBuilder();
                    for (int i = 0; i < len; i++) {
                        palavraDiagonal.append(matriz[linha + i][coluna - i]);
                    }
                    if (eUmPalindromo(palavraDiagonal.toString())) {
                        inserirPalindromoNaLista(palavraDiagonal.toString());
                    }
                }
            }
        }
        return palavrasPalindromo;
    }

    public static void inserirPalindromoNaLista(String palavra) {
        Palavra encontradoPalindromo = new Palavra();
        encontradoPalindromo.setDescricao(palavra);
        palavrasPalindromo.add(encontradoPalindromo);
    }

    public static boolean eUmPalindromo(String palavra) {
        palavra = palavra.replaceAll("\\s", "").toLowerCase();
        if (palavra.length() < 4) {
            return false;
        }
        int comprimento = palavra.length();
        for (int i = 0; i < comprimento / 2; i++) {
            if (palavra.charAt(i) != palavra.charAt(comprimento - i - 1)) {
                return false;
            }
        }
        return true;
    }

    private List<Palavra> salvarPalindromos(List<Palavra> palavrasPalindromo) {
        return palavraRepository.saveAll(palavrasPalindromo);

    }

    public List<Palavra> salvarTodosPalindromos() {
        return palavraRepository.findAll();
    }

    public Optional<Palavra> buscarPalindromoPorId(Long id) {
        return palavraRepository.findById(id);
    }
}
