package com.ada.salaryManagment.mapper;

import com.ada.salaryManagment.dto.SalarioDTO;
import com.ada.salaryManagment.model.Salario;
import com.ada.salaryManagment.model.Salario;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SalarioMapper {

    public static SalarioDTO parseToDto(Salario salario){
        return new SalarioDTO(salario.getId(), salario.getIdade(), salario.getGenero(),salario.getEscolaridade(),salario.getCargo(), salario.getTempoDeExperienciaEmAnos(), salario.getSalario());
    }

    public static Salario parseToEntity(SalarioDTO salario){
        return new Salario(salario.getId(), salario.getIdade(), salario.getGenero(),salario.getEscolaridade(),salario.getCargo(), salario.getTempoDeExperienciaEmAnos(), salario.getSalario());
    }


}
