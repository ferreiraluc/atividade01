package com.example.atividade01.dto;

import com.example.atividade01.model.Endereco;
import com.example.atividade01.model.Paciente;

public class PacienteDTO {

    private Long id;
    private String nome;
    private String cpf;
    private String email;
    private String telefone;
    private Endereco endereco;

    public PacienteDTO(Paciente paciente){
        id = paciente.getId();
        nome = paciente.getNome();
        cpf = paciente.getCpf();
        email = paciente.getEmail();
        telefone = paciente.getTelefone();
        endereco = paciente.getEndereco();
    }

    public PacienteDTO(Long id, String nome, String cpf, String email, String telefone, Endereco endereco) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.telefone = telefone;
        this.endereco = endereco;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    //Getters e Setters

}
