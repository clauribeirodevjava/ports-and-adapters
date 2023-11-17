package com.example.palindromos.adapter.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.palindromos.adapter.entities.EntityMatriz;
import com.example.palindromos.domain.Palavra;
import com.example.palindromos.domain.services.PalavraService;

@RestController
@RequestMapping("/api")
public class PalavraController {
	private final PalavraService palavraService;

	public PalavraController(PalavraService palavraService) {
		this.palavraService = palavraService;
	}

	@PostMapping("palindromos")
	public String encontrarPalindromos(@RequestBody EntityMatriz entityMatriz) {

		List<Palavra> encontradosPalindromos = palavraService.encontrarPalindromos(entityMatriz);
		palavraService.saveAll(encontradosPalindromos);
		return "Lista de palíndromos: " + encontradosPalindromos.toString();
	}

	@GetMapping("todos")
	private List<Palavra> findAllPalavra() {
		return palavraService.findAllPalavra();
	}
}