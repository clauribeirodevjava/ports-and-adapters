package com.example.palindromos.domain;

public class Palavra {
    private Long id;

    private String descricao;

    private Boolean confere;

    public Palavra() {

    }

    public Palavra(Long id, String descricao, Boolean confere) {
        this.id = id;
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

    public Boolean getConfere() {
        return confere;
    }

    public void setConfere(Boolean confere) {
        this.confere = confere;
    }
}
