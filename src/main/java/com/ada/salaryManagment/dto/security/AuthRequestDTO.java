package com.ada.salaryManagment.dto.security;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class AuthRequestDTO {

    @NotBlank(message = "O campo Username é obrigatório!")
    private String usuario;

    @NotBlank(message = "O campo Password é obrigatório!")
    @Size(min = 8, message = "Senha deve conter no mínimo 8 caracteres")
    private String senha;

    public AuthRequestDTO(String username, String password) {
        this.usuario = username;
        this.senha = password;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
