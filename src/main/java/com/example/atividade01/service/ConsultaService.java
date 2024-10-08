package com.example.atividade01.service;

import com.example.atividade01.model.Consulta;
import com.example.atividade01.model.Paciente;
import com.example.atividade01.repository.ConsultaRepository;
import com.example.atividade01.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ConsultaService {

    @Autowired
    private ConsultaRepository consultaRepository;

    @Autowired
    private PacienteRepository pacienteRepository;

    public Consulta agendarConsulta(Consulta consulta) {
        // Verifica se o paciente existe
        Paciente paciente = pacienteRepository.findById(consulta.getPaciente().getId())
                .orElseThrow(() -> new RuntimeException("Paciente não encontrado"));
        consulta.setPaciente(paciente);

        // Define a data e hora da consulta (se não estiver definida)
        if (consulta.getDataHora() == null) {
            consulta.setDataHora(LocalDateTime.now());
        }

        return consultaRepository.save(consulta);
    }

    public Consulta atualizarConsulta(Consulta consulta) {
        return consultaRepository.save(consulta);
    }

    public List<Consulta> buscarTodasConsultas() {
        return consultaRepository.findAll();
    }

    public Optional<Consulta> buscarConsultaPorId(Long id) {
        return consultaRepository.findById(id);
    }

    public List<Consulta> buscarConsultasPorPeriodo(LocalDateTime dataInicio, LocalDateTime dataFim) {
        return consultaRepository.findByDataHoraBetween(dataInicio, dataFim);
    }

    public List<Consulta> buscarConsultasPorPaciente(Long pacienteId) {
        return consultaRepository.findByPacienteId(pacienteId);
    }

    public void excluirConsulta(Long id) {
        consultaRepository.deleteById(id);
    }
}