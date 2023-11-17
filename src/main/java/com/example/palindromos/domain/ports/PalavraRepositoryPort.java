package com.example.palindromos.domain.ports;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.palindromos.domain.Palavra;

@Repository
public interface PalavraRepositoryPort extends JpaRepository<Palavra, Long> {
}
