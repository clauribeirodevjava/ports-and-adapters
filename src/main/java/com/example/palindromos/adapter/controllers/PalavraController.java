package com.example.palindromos.adapter.controllers;
import com.example.palindromos.adapter.entities.EntityMatriz;
import com.example.palindromos.domain.Palavra;
import com.example.palindromos.domain.ports.PalavraServicePort;
import com.example.palindromos.domain.services.impl.PalavraServiceImpl;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/api")
public class PalavraController {
    private final PalavraServiceImpl palavraService;
    private final PalavraServicePort palavraServicePort;
    public PalavraController(PalavraServiceImpl palavraService, PalavraServicePort palavraServicePort) {
        this.palavraService = palavraService;
        this.palavraServicePort = palavraServicePort;
    }
    @PostMapping("palindromos")
    public String encontrarPalindromos(@RequestBody EntityMatriz entityMatriz) {
        // Lógica para encontrar palíndromos usando palavraService
        char[][] matriz = entityMatriz.getMatriz();

        List<String> encontradosPalindromos = Collections.singletonList(palavraService.encontrarPalindromos(entityMatriz));

        return "Lista de palíndromos: " + encontradosPalindromos.toString();
    }
    public List<String> encontradosPalindromos(@RequestBody EntityMatriz entityMatriz) {
        return Collections.singletonList(palavraService.encontrarPalindromos(entityMatriz));
    }
    @GetMapping("todos")
       private List<Palavra> findAllPalavra() {
        return palavraServicePort.findAllPalavra();
    }
}