package com.ada.salaryManagment.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "email", unique = true, nullable = false)
    private String email;

    @Column(name = "senha", nullable = false)
    private String password;

    @Column(name = "CPF", unique = true, nullable = false)
    private String cpf;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "dtCriacao", nullable = false)
    private LocalDateTime dataCriacao;

    public Usuario(Long id, String cpf, String nome, String email, LocalDateTime dataCriacao) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.cpf = cpf;
        this.nome = nome;
        this.dataCriacao = dataCriacao;
    }

    public Usuario() {
    }


    public Usuario(Long id, String cpf, String nome, String email, String pass) {
        this.id=id;
        this.email = email;
        this.password = pass;
        this.cpf = cpf;
        this.nome = nome;
        this.dataCriacao = LocalDateTime.now();
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }
}
