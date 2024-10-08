package com.example.atividade01.dto;

import com.example.atividade01.model.Endereco;

public class EnderecoDTO {

    private Long id;
    private String estado;
    private String cidade;
    private String rua;
    private int numero;
    private String cep;

    public EnderecoDTO(Endereco endereco){
        id = endereco.getId();
        estado = endereco.getEstado();
        cidade = endereco.getCidade();
        rua = endereco.getRua();
        numero = endereco.getNumero();
        cep = endereco.getCep();
    }

    public EnderecoDTO(Long id, String estado, String cidade, String rua, int numero, String cep) {
        this.id = id;
        this.estado = estado;
        this.cidade = cidade;
        this.rua = rua;
        this.numero = numero;
        this.cep = cep;
    }

    //Getters e Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }
}