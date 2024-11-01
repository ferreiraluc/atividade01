package com.example.atividade01.service;

import com.example.atividade01.auditing.Audit;
import com.example.atividade01.model.Consulta;
import com.example.atividade01.model.Paciente;
import com.example.atividade01.repository.AuditRepository;
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

    @Autowired
    private AuditRepository auditRepository;

    public Consulta agendarConsulta(Consulta consulta) {
        // Verifica se o paciente existe
        Paciente paciente = pacienteRepository.findById(consulta.getPaciente().getId())
                .orElseThrow(() -> new RuntimeException("Paciente não encontrado"));
        consulta.setPaciente(paciente);

        // Define a data e hora da consulta (se não estiver definida)
        if (consulta.getDataHora() == null) {
            consulta.setDataHora(LocalDateTime.now());
        }

        // Salva a consulta
        Consulta novaConsulta = consultaRepository.save(consulta);

        // Registra a operação de auditoria (CREATE)
        Audit audit = new Audit();
        audit.setOperation("CREATE");
        audit.setCreatedBy(paciente.getId()); // Assumindo que o ID do paciente representa o usuário
        audit.setCreateDate(LocalDateTime.now());
        auditRepository.save(audit);

        return novaConsulta;
    }

    public Consulta atualizarConsulta(Consulta consulta) {
        // Atualiza a consulta
        Consulta consultaAtualizada = consultaRepository.save(consulta);

        // Registra a operação de auditoria (UPDATE)
        Audit audit = new Audit();
        audit.setOperation("UPDATE");
        audit.setCreatedBy(consulta.getPaciente().getId());
        audit.setCreateDate(LocalDateTime.now());
        auditRepository.save(audit);

        return consultaAtualizada;
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
        Optional<Consulta> consultaOptional = consultaRepository.findById(id);
        if (consultaOptional.isPresent()) {
            // Exclui a consulta
            consultaRepository.deleteById(id);

            // Registra a operação de auditoria (DELETE)
            Audit audit = new Audit();
            audit.setOperation("DELETE");
            audit.setCreatedBy(consultaOptional.get().getPaciente().getId());
            audit.setCreateDate(LocalDateTime.now());
            auditRepository.save(audit);
        } else {
            throw new RuntimeException("Consulta não encontrada");
        }
    }
}
