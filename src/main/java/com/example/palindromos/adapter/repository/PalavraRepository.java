package com.example.palindromos.adapter.repository;

import com.example.palindromos.adapter.entities.PalavraEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PalavraRepository extends JpaRepository<PalavraEntity, Long> {
}
