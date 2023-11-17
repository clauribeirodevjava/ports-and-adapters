package com.example.palindromos.adapter.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.palindromos.adapter.entities.Palavra;
import com.example.palindromos.domain.ports.PalavraRepositoryPort;

public interface PalavraRepositoryAdapter extends JpaRepository<Palavra, Long>, PalavraRepositoryPort {
	@Override
	default List<Palavra> savePalavras(List<Palavra> palavras) {
		return saveAll(palavras);
	}

	@Override
	default List<Palavra> findAllPalavras() {
		return findAll();
	}

}
