package com.ada.salaryManagment.model;

import jakarta.persistence.*;

@Entity
@Table(name = "salario")
public class Salario {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "idade")
    private Integer idade;
    @Column(name = "genero")
    private String genero;
    @Column(name = "escolaridade")
    private String escolaridade;
    @Column(name = "cargo")
    private String cargo;
    @Column(name = "tempoDeExperienciaEmAnos")
    private Double tempoDeExperienciaEmAnos;
    @Column(name = "salario")
    private Double salario;

    public Salario(Long id, Integer idade, String genero, String escolaridade, String cargo, Double tempoDeExperienciaEmAnos, Double salario) {
        this.id = id;
        this.idade = idade;
        this.genero = genero;
        this.escolaridade = escolaridade;
        this.cargo = cargo;
        this.tempoDeExperienciaEmAnos = tempoDeExperienciaEmAnos;
        this.salario = salario;
    }

    public Salario() {
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getEscolaridade() {
        return escolaridade;
    }

    public void setEscolaridade(String escolaridade) {
        this.escolaridade = escolaridade;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public Double getTempoDeExperienciaEmAnos() {
        return tempoDeExperienciaEmAnos;
    }

    public void setTempoDeExperienciaEmAnos(Double tempoDeExperienciaEmAnos) {
        this.tempoDeExperienciaEmAnos = tempoDeExperienciaEmAnos;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }
}
