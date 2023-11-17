package com.example.palindromos.domain;

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

	private Boolean confere;

	public Palavra() {
	}

	public Palavra(String descricao, Boolean confere) {
		this.descricao = descricao;
		this.confere = confere;
		
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


	@Override
	public String toString() {
		return "Palavra [descricao=" + descricao + "]";
	}

	public Boolean getConfere() {
		return confere;
	}

	public void setConfere(Boolean confere) {
		this.confere = confere;
	}
}
