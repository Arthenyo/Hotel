package com.arthenyo.Hotel.enums;

public enum TipoUsuario {

    FUNCIONARIO("Funcionario"),
    HOSPEDE("Hospede");

    private String descricao;

    TipoUsuario(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    @Override
    public String toString() {
        return this.descricao;
    }
}
