package com.example.palindromos.adapter.controllers;
import com.example.palindromos.domain.Palavra;
import com.example.palindromos.domain.ports.PalavraServicePort;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("palindromos")

public class PalavraController {

    private final PalavraServicePort palavraServicePort;

    public PalavraController(PalavraServicePort palavraServicePort) {
        this.palavraServicePort = palavraServicePort;
    }

    @PostMapping
    private Palavra create(@RequestBody Palavra palavra) {
        return palavraServicePort.savePalavra(palavra);
    }

    @GetMapping
       private List<Palavra> findAll() {
        return palavraServicePort.findAllPalavra();
    }

}