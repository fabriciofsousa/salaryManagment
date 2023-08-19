package com.ada.salaryManagment.mapper;

import com.ada.salaryManagment.dto.NovoCadastrodeUsuarioDTO;
import com.ada.salaryManagment.dto.UsuarioDTO;
import com.ada.salaryManagment.model.Usuario;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
public class UsuarioMapper {

    public static UsuarioDTO parseToDto(Usuario usuario){
        return new UsuarioDTO(usuario.getId(), usuario.getCpf(), usuario.getNome(),usuario.getEmail(),usuario.getDataCriacao());
    }
    public static Usuario parseToEntity(UsuarioDTO usuario){
        return new Usuario(usuario.getId(), usuario.getCpf(), usuario.getNome(),usuario.getEmail(),usuario.getDataCriacao());
    }

    public static Usuario parseToEntity(NovoCadastrodeUsuarioDTO usuario){
        return new Usuario(usuario.getId(),usuario.getCpf(), usuario.getNome(),usuario.getEmail(),usuario.getPass());
    }

}

