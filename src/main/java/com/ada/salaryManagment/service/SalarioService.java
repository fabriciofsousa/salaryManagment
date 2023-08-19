package com.ada.salaryManagment.service;

import com.ada.salaryManagment.dto.NovoCadastrodeUsuarioDTO;
import com.ada.salaryManagment.dto.SalarioDTO;
import com.ada.salaryManagment.dto.UsuarioDTO;
import com.ada.salaryManagment.exception.SalarioNaoEncontradoException;
import com.ada.salaryManagment.mapper.SalarioMapper;
import com.ada.salaryManagment.mapper.UsuarioMapper;
import com.ada.salaryManagment.model.Salario;
import com.ada.salaryManagment.repository.SalarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SalarioService {

    @Autowired
    private SalarioRepository repo;

    public SalarioDTO salvar(SalarioDTO usuario){
        return SalarioMapper.parseToDto(repo.save(SalarioMapper.parseToEntity(usuario)));
    }

    public List<SalarioDTO> findAll(){
        return repo.findAll()
                .stream()
                .map(SalarioMapper::parseToDto)
                .collect(Collectors.toList());
    }

    public SalarioDTO findById(Long id) {
        Salario salario = repo
                .findById(id)
                .orElseThrow(() -> new SalarioNaoEncontradoException("Salário de ID " + id + " não encontrado."));

        return SalarioMapper.parseToDto(salario);
    }

    public SalarioDTO atualizar(SalarioDTO salarioDTO, Long id) {
        findById(id);
        Salario salario = SalarioMapper.parseToEntity(salarioDTO);
        salario.setId(id);

        return SalarioMapper
                .parseToDto(repo.save(salario));

    }

    public void deletar(Long id) {
        findById(id);
        repo.deleteById(id);
    }
}
