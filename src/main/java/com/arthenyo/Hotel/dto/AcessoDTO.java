package com.arthenyo.Hotel.dto;

import com.arthenyo.Hotel.model.Acesso;

public class AcessoDTO {
    private Long id;
    private String descricao;

    public AcessoDTO(Long id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }
    public AcessoDTO(Acesso entity) {
        id = entity.getId();
        descricao = entity.getDescricao();
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
}
