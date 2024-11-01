package com.example.atividade01.service;

import com.example.atividade01.auditing.Audit;
import com.example.atividade01.model.Paciente;
import com.example.atividade01.repository.AuditRepository;
import com.example.atividade01.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class PacienteService {

    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    private AuditRepository auditRepository;

    // Salvar um paciente
    public Paciente salvarPaciente(Paciente paciente) {
        Paciente novoPaciente = pacienteRepository.save(paciente);

        // Registra a operação de auditoria (CREATE)
        Audit audit = new Audit("CREATE_PACIENTE", 1L);  // Substitua "1L" pelo ID do usuário real
        audit.setCreateDate(LocalDateTime.now());
        auditRepository.save(audit);

        return novoPaciente;
    }

    // Atualizar um paciente
    public Paciente atualizarPaciente(Paciente paciente) {
        Paciente pacienteAtualizado = pacienteRepository.save(paciente);

        // Registra a operação de auditoria (UPDATE)
        Audit audit = new Audit("UPDATE_PACIENTE", 1L);  // Substitua "1L" pelo ID do usuário real
        audit.setCreateDate(LocalDateTime.now());
        auditRepository.save(audit);

        return pacienteAtualizado;
    }

    // Buscar todos os pacientes
    public List<Paciente> buscarTodosPacientes() {
        return pacienteRepository.findAll();
    }

    // Buscar paciente por ID
    public Optional<Paciente> buscarPacientePorId(Long id) {
        return pacienteRepository.findById(id);
    }

    // Buscar pacientes por nome (case insensitive)
    public List<Paciente> buscarPacientesPorNome(String nome) {
        return pacienteRepository.findByNomeContainingIgnoreCase(nome);
    }

    // Excluir paciente por ID
    public void excluirPaciente(Long id) {
        Optional<Paciente> pacienteOptional = pacienteRepository.findById(id);

        if (pacienteOptional.isPresent()) {
            pacienteRepository.deleteById(id);

            // Registra a operação de auditoria (DELETE)
            Audit audit = new Audit("DELETE_PACIENTE", 1L);  // Substitua "1L" pelo ID do usuário real
            audit.setCreateDate(LocalDateTime.now());
            auditRepository.save(audit);
        } else {
            throw new IllegalArgumentException("Paciente não encontrado para o ID informado!");
        }
    }
}
