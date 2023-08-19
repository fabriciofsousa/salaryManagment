package com.ada.salaryManagment.controller;

import com.ada.salaryManagment.dto.NovoCadastrodeUsuarioDTO;
import com.ada.salaryManagment.dto.SalarioDTO;
import com.ada.salaryManagment.dto.UsuarioDTO;
import com.ada.salaryManagment.mapper.SalarioMapper;
import com.ada.salaryManagment.mapper.UsuarioMapper;
import com.ada.salaryManagment.model.Salario;
import com.ada.salaryManagment.service.SalarioService;
import com.ada.salaryManagment.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/salario")
public class SalarioController {


    @Autowired
    SalarioService salarioService;


    @GetMapping
    public ResponseEntity<List<SalarioDTO>> findAllSalario() {
        return ResponseEntity.ok(salarioService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<SalarioDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(salarioService.findById(id));
    }
    @PostMapping
    public ResponseEntity<SalarioDTO> salvar(@RequestBody @Valid SalarioDTO salario) {
        SalarioDTO salarioSalvo = salarioService.salvar(salario);

        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(salarioSalvo.getId())
                .toUri();

        return ResponseEntity.created(uri).body(salarioSalvo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SalarioDTO> atualizar(@RequestBody SalarioDTO salario,
                                                @PathVariable Long id) {
        return ResponseEntity.ok(salarioService.atualizar(salario, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        salarioService.deletar(id);
        return ResponseEntity.noContent().build();
    }

}
