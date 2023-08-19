package com.ada.salaryManagment.service;

import com.ada.salaryManagment.dto.NovoCadastrodeUsuarioDTO;
import com.ada.salaryManagment.dto.SalarioDTO;
import com.ada.salaryManagment.dto.UsuarioDTO;
import com.ada.salaryManagment.exception.UsuarioNaoEncontradoException;
import com.ada.salaryManagment.mapper.SalarioMapper;
import com.ada.salaryManagment.mapper.UsuarioMapper;
import com.ada.salaryManagment.model.Salario;
import com.ada.salaryManagment.model.Usuario;
import com.ada.salaryManagment.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repo;

    private final PasswordEncoder encoder;

    public UsuarioService(PasswordEncoder encoder) {
        this.encoder = encoder;
    }

    public List<UsuarioDTO> findAll(){
        return repo.findAll().stream().map(UsuarioMapper::parseToDto).collect(Collectors.toList());
    }

    public Optional<Usuario> findByEmail(String email){
        return repo.findByEmail(email);
    }

    public UsuarioDTO salvar(NovoCadastrodeUsuarioDTO usuario){
        usuario.setPass(encoder.encode(usuario.getPass()));
        return UsuarioMapper.parseToDto(repo.save(UsuarioMapper.parseToEntity(usuario)));
    }

    public UsuarioDTO findById(Long id) {
        Usuario usuario = repo
                .findById(id)
                .orElseThrow(() -> new UsuarioNaoEncontradoException("Usuario de ID " + id + " não encontrado."));

        return UsuarioMapper.parseToDto(usuario);
    }

    public UsuarioDTO atualizar(NovoCadastrodeUsuarioDTO usuarioDTO, Long id) {
        findById(id);
        Usuario usuario = UsuarioMapper.parseToEntity(usuarioDTO);
        usuario.setId(id);

        return UsuarioMapper
                .parseToDto(repo.save(usuario));

    }

    public void deletar(Long id) {
        findById(id);
        repo.deleteById(id);
    }
}
