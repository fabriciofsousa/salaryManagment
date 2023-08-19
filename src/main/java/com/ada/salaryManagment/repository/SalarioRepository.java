package com.ada.salaryManagment.repository;

import com.ada.salaryManagment.model.Salario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalarioRepository extends JpaRepository<Salario, Long> {

}
