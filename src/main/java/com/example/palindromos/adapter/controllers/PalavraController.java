package com.example.palindromos.adapter.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.palindromos.adapter.dto.MatrizDTO;
import com.example.palindromos.adapter.dto.PalavraDTO;
import com.example.palindromos.domain.services.PalavraServiceAdapter;

@RestController
@RequestMapping("/api")
public class PalavraController implements PalavraControllerInterface{
	private final PalavraServiceAdapter palavraService;

	public PalavraController(PalavraServiceAdapter palavraService) {
		this.palavraService = palavraService;
	}

	@PostMapping("palindromos")
	public  ResponseEntity<List<PalavraDTO>> encontrarPalindromos(@RequestBody MatrizDTO entityMatriz) {

		List<PalavraDTO> encontradosPalindromos = palavraService.encontrarPalindromos(entityMatriz);
		palavraService.saveAll(encontradosPalindromos);
		return ResponseEntity.ok(encontradosPalindromos);
	}

	@GetMapping("palindromos")
	public List<PalavraDTO> findAllPalavra() {
		return palavraService.findAllPalavra();
	}
}