package com.example.atividade01.repository;
import com.example.atividade01.model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface PacienteRepository extends JpaRepository<Paciente, Long> {

    List<Paciente> findByNomeContainingIgnoreCase(String nome);

}
