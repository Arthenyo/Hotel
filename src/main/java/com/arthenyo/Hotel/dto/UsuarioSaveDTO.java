package com.arthenyo.Hotel.dto;

import com.arthenyo.Hotel.enums.TipoUsuario;
import com.arthenyo.Hotel.model.Usuario;

import java.util.HashSet;
import java.util.Set;

public class UsuarioSaveDTO {
    private Long id;
    private String nome;
    private String cpf;
    private String email;
    private String telefone;
    private TipoUsuario tipoUsuario;
    private String senha;
    private Set<AcessoDTO> acessos = new HashSet<>();

    public UsuarioSaveDTO(Long id, String nome, String cpf, String email, String telefone, TipoUsuario tipoUsuario, String senha) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.telefone = telefone;
        this.tipoUsuario = tipoUsuario;
        this.senha = senha;
    }
    public UsuarioSaveDTO(Usuario entity) {
        id = entity.getId();
        nome = entity.getNome();
        cpf = entity.getCpf();
        email = entity.getEmail();
        telefone = entity.getTelefone();
        tipoUsuario = entity.getTipoUsuario();
        senha = entity.getSenha();
        entity.getAcessos().forEach(role -> this.acessos.add(new AcessoDTO(role)));
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public TipoUsuario getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(TipoUsuario tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Set<AcessoDTO> getAcessos() {
        return acessos;
    }

    public void setAcessos(Set<AcessoDTO> acessos) {
        this.acessos = acessos;
    }
}
