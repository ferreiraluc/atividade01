package com.example.atividade01.repository;

import com.example.atividade01.model.Consulta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ConsultaRepository extends JpaRepository<Consulta, Long> {

    List<Consulta> findByPacienteId(Long pacienteId);
    List<Consulta> findByDataHoraBetween(LocalDateTime dataInicio, LocalDateTime dataFim);
}
