package com.example.palindromos.adapter.dto;

import com.example.palindromos.adapter.entities.Palavra;
import com.fasterxml.jackson.annotation.JsonInclude;
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PalavraDTO {

	private String descricao;

	public PalavraDTO(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

	@Override
	public String toString() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Palavra toEntity() {
		return new Palavra(descricao);
	}

}