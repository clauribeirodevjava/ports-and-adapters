package com.example.palindromos.adapter.entities;

import com.example.palindromos.adapter.dto.PalavraDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Palavra {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String descricao;

	public Palavra() {
	}

	public Palavra(String descricao) {
		this.descricao = descricao;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public PalavraDTO toDTO() {
		return new PalavraDTO(descricao);
	}

	@Override
	public String toString() {
		return "Palavra [descricao=" + descricao + "]";
	}
}
