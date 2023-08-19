package com.ada.salaryManagment.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.br.CPF;

public class NovoCadastrodeUsuarioDTO {

        private Long id;
        @NotNull(message = "Oampo e-mail não pode ser nulo ou vazio!")
        @Email
        private String email;

        @JsonProperty("password")
        @NotBlank(message = "A senha é obrigatória!!!")
        @Size(min = 8, message = "Password deve conter no minimo 8 caracteres!")
        private String pass;

        @NotBlank(message = "O campo nome não pode ser vazio")
        @Size(min = 3, message = "O campo nome deve possuir no mínimo três caracteres!")
        private String nome;

        @NotBlank(message = "O CPF não pode ser vazio!")
        @CPF(message = "CPF inválido")
        private String cpf;

        private Integer idade;

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getPass() {
            return pass;
        }

        public void setPass(String pass) {
            this.pass = pass;
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
}

