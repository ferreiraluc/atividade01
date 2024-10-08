package com.example.atividade01.dto;

import com.example.atividade01.model.Consulta;
import com.example.atividade01.model.Paciente;

import java.time.LocalDateTime;

public class ConsultaDTO {

    private Long id;
    private LocalDateTime data;
    private Paciente paciente;

    public ConsultaDTO(Consulta consulta){
        id = consulta.getId();
        data = consulta.getDataHora();
        paciente = consulta.getPaciente();
    }

    public ConsultaDTO(Long id, LocalDateTime data, Paciente paciente) {
        this.id = id;
        this.data = data;
        this.paciente = paciente;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }


}
