package com.ada.salaryManagment.dto;

import jakarta.persistence.*;

public class SalarioDTO {
        private Long id;
        private Integer idade;
        private String genero;
        private String escolaridade;
        private String cargo;
        private Double tempoDeExperienciaEmAnos;
        private Double salario;

    public SalarioDTO() {
    }
    public SalarioDTO(Long id, Integer idade, String genero, String escolaridade, String cargo, Double tempoDeExperienciaEmAnos, Double salario) {
        this.id = id;
        this.idade = idade;
        this.genero = genero;
        this.escolaridade = escolaridade;
        this.cargo = cargo;
        this.tempoDeExperienciaEmAnos = tempoDeExperienciaEmAnos;
        this.salario = salario;
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
