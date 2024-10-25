package com.example.atividade01.controller;

import com.example.atividade01.model.Consulta;
import com.example.atividade01.service.ConsultaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/consultas")
public class ConsultaController {

    @Autowired
    private ConsultaService consultaService;

    @GetMapping
    public ResponseEntity<List<Consulta>> buscarTodasConsultas() {
        return ResponseEntity.ok(consultaService.buscarTodasConsultas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Consulta> buscarConsultaPorId(@PathVariable Long id) {
        return consultaService.buscarConsultaPorId(id)
                .map(consulta -> ResponseEntity.ok(consulta))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Consulta> agendarConsulta(@RequestBody Consulta consulta) {
        return ResponseEntity.ok(consultaService.agendarConsulta(consulta));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Consulta> atualizarConsulta(@PathVariable Long id, @RequestBody Consulta consulta) {
        consulta.setId(id);
        return ResponseEntity.ok(consultaService.atualizarConsulta(consulta));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirConsulta(@PathVariable Long id) {
        consultaService.excluirConsulta(id);
        return ResponseEntity.noContent().build();
    }


    @GetMapping("/paciente/{pacienteId}")
    public ResponseEntity<List<Consulta>> buscarConsultasPorPaciente(@PathVariable Long pacienteId) {
        return ResponseEntity.ok(consultaService.buscarConsultasPorPaciente(pacienteId));
    }

    @GetMapping("/periodo")
    public ResponseEntity<List<Consulta>> buscarConsultasPorPeriodo(
            @RequestParam("dataInicio") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dataInicio,
            @RequestParam("dataFim") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dataFim) {
        return ResponseEntity.ok(consultaService.buscarConsultasPorPeriodo(dataInicio, dataFim));
    }
}