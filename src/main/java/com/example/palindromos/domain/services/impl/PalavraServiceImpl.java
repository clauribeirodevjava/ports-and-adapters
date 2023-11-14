package com.example.palindromos.domain.services.impl;

import com.example.palindromos.adapter.entities.PalavraEntity;
import com.example.palindromos.adapter.repository.PalavraRepository;
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

    private PalavraRepository palavraPalindromoRepository;

    private static List<PalavraEntity> palavrasPalindromo = new ArrayList<>();

    public PalavraServiceImpl(PalavraRepositoryPort palavraRepositoryPort) {
        super(palavraRepositoryPort);
    }

    public List<PalavraEntity> encontrarPalavrasPalindromos(String jsonMatriz) {

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
                    System.out.println("Matriz não quadrada. Número de colunas na linha " + i
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
            System.out.println("Erro na analise do JSON: " + e.getMessage());
            return null;
        }
    }
    // Itera sobre a matriz para encontrar palíndromos em diferentes direções.
    public List<PalavraEntity> encontrarPalindromosNaMatriz(char[][] matriz) {
        int numLinhas = matriz.length;
        int numCols = matriz[0].length;
        for (int linha = 0; linha < numLinhas; linha++) {
            for (int coluna = 0; coluna < numCols; coluna++) {
                // Horizontal (esquerda para direita)
                for (int len = 1; coluna + len <= numCols; len++) {
                    String palavraHorizontal = new String(matriz[linha], coluna, len);
                    if (eUmPalindromo(palavraHorizontal)) {
                        PalavraEntity encontradoPalindromo = new PalavraEntity();
                        encontradoPalindromo.setDescricao(palavraHorizontal);
                        inserirPalindromoNaLista(palavraHorizontal);
                    }
                }

                // Verifica palíndromos na direção vertical (cima para baixo).
                for (int len = 1; linha + len <= numLinhas; len++) {
                    StringBuilder palavraVertical = new StringBuilder();
                    for (int i = 0; i < len; i++) {
                        palavraVertical.append(matriz[linha + i][coluna]);
                    }
                    if (eUmPalindromo(palavraVertical.toString())) {
                        inserirPalindromoNaLista(palavraVertical.toString());
                    }
                }


                // Verifica palíndromos na direção diagonal (cima-esquerda para baixo-direita).
                for (int len = 1; linha + len <= numLinhas && coluna + len <= numCols; len++) {
                    StringBuilder palavraDiagonal = new StringBuilder();
                    for (int i = 0; i < len; i++) {
                        palavraDiagonal.append(matriz[linha + i][coluna + i]);
                    }
                    if (eUmPalindromo(palavraDiagonal.toString())) {
                        inserirPalindromoNaLista(palavraDiagonal.toString());
                    }
                }

                // Verifica palíndromos na direção diagonal (cima-direita para baixo-esquerda).
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
    // Método para inserir um palíndromo na lista de palíndromos.
    public static void inserirPalindromoNaLista(String palavraEntity) {
        PalavraEntity encontradoPalindromo = new PalavraEntity();
        encontradoPalindromo.setDescricao(palavraEntity);
        palavrasPalindromo.add(encontradoPalindromo);
    }
    // Método para verificar se uma palavra é um palíndromo.
    public static boolean eUmPalindromo(String descricao) {
        descricao = descricao.replaceAll("\\s", "").toLowerCase();
        if (descricao.length() < 4) {
            return false;
        }
        int comprimento = descricao.length();
        for (int i = 0; i < comprimento / 2; i++) {
            if (descricao.charAt(i) != descricao.charAt(comprimento - i - 1)) {
                return false;
            }
        }
        return true;
    }
    // Método para salvar palíndromos no repositório.
    private List<PalavraEntity> salvarPalindromos(List<PalavraEntity> palavrasPalindromo) {
        return palavraPalindromoRepository.saveAll(palavrasPalindromo);
    }
    // Método para listar todos os palíndromos no repositório.
    public List<PalavraEntity> listarPalindromos() {
        return palavraPalindromoRepository.findAll();
    }
    // Método para buscar um palíndromo por ID no repositório.
    public Optional<PalavraEntity> buscarPalindromoPorId(Long id) {
        return palavraPalindromoRepository.findById(id);
    }
}
