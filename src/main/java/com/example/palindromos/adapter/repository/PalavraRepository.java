package com.example.palindromos.adapter.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.palindromos.adapter.entities.PalavraEntity;

public interface PalavraRepository extends JpaRepository<PalavraEntity, Long> {
}
