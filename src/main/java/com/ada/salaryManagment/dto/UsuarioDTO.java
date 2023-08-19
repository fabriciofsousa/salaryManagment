package com.ada.salaryManagment.dto;

import java.time.LocalDateTime;

public class UsuarioDTO {

    private Long id;
    private String cpf;
    private String nome;
    private String email;
    private LocalDateTime dataCriacao;

    public UsuarioDTO() {
    }

    public UsuarioDTO(Long id, String cpf, String nome, String email, LocalDateTime dataCriacao) {
        this.id = id;
        this.cpf = cpf;
        this.nome = nome;
        this.email = email;
        this.dataCriacao = dataCriacao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }
}
