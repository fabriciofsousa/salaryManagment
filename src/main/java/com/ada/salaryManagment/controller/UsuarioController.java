package com.ada.salaryManagment.controller;


import com.ada.salaryManagment.dto.NovoCadastrodeUsuarioDTO;
import com.ada.salaryManagment.dto.UsuarioDTO;
import com.ada.salaryManagment.mapper.UsuarioMapper;
import com.ada.salaryManagment.model.Usuario;
import com.ada.salaryManagment.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

    @GetMapping
    public ResponseEntity<List<UsuarioDTO>> findAllUsuarios() {
        return ResponseEntity.ok(usuarioService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(usuarioService.findById(id));
    }
    @PostMapping
    public ResponseEntity<UsuarioDTO> salvar(@RequestBody @Valid NovoCadastrodeUsuarioDTO usuario) {
        UsuarioDTO usuarioSalvo = usuarioService.salvar(usuario);

        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(usuarioSalvo.getId())
                .toUri();

        return ResponseEntity.created(uri).body(usuarioSalvo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsuarioDTO> atualizar(@RequestBody NovoCadastrodeUsuarioDTO usuario,
                                                @PathVariable Long id) {
        return ResponseEntity.ok(usuarioService.atualizar(usuario, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        usuarioService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
