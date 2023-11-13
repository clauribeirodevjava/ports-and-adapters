package com.example.palindromos.domain;

public class Palavra {
    private Integer id;

    private String descricao;

    private Boolean confere;

    public Palavra() {

    }

    public Palavra(Integer id, String descricao, Boolean confere) {
        this.id = id;
        this.descricao = descricao;
        this.confere = confere;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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
