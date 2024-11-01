package com.example.atividade01.dto;

import java.time.LocalDateTime;

public class AuditDTO {

    private Long id;
    private String operation;
    private Long createdBy;
    private LocalDateTime createDate;

    // Construtor sem parâmetros
    public AuditDTO() {
    }

    // Construtor com parâmetros
    public AuditDTO(Long id, String operation, Long createdBy, LocalDateTime createDate) {
        this.id = id;
        this.operation = operation;
        this.createdBy = createdBy;
        this.createDate = createDate;
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public Long getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }
}
