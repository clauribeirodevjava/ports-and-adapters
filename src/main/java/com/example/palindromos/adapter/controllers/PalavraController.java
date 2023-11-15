package com.example.palindromos.adapter.controllers;
import com.example.palindromos.adapter.entities.PalavraEntity;
import com.example.palindromos.domain.Palavra;
import com.example.palindromos.domain.ports.PalavraServicePort;
import com.example.palindromos.domain.services.impl.PalavraServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class PalavraController {

    @Autowired
    private PalavraServiceImpl palavraService;
    private final PalavraServicePort palavraServicePort;

    public PalavraController(PalavraServicePort palavraServicePort) {
        this.palavraServicePort = palavraServicePort;
    }

    @PostMapping("palindromos")
    private Palavra create(@RequestBody Palavra palavra) {
        return palavraServicePort.savePalavra(palavra);
    }

    public List<PalavraEntity> encontrarPalavrasPalindromos(@RequestBody String matriz) {
        return palavraService.encontrarPalavrasPalindromos(matriz);
    }

    @GetMapping("todos")
       private List<Palavra> findAllPalavra() {
        return palavraServicePort.findAllPalavra();
    }

}