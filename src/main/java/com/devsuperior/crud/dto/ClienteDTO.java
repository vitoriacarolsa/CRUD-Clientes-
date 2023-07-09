package com.devsuperior.crud.dto;

import com.devsuperior.crud.entidades.Cliente;

import java.time.LocalDate;

public class ClienteDTO {
    private Long id;
    private String name;
    private String cpf;
    private Double income;
    private LocalDate birthDate;
    private Integer children;

    public ClienteDTO(){
    }

    public ClienteDTO(Long id, String name, String cpf, Double income, LocalDate birthDate, Integer children) {
        this.id = id;
        this.name = name;
        this.cpf = cpf;
        this.income = income;
        this.birthDate = birthDate;
        this.children = children;
    }

    public ClienteDTO(Cliente entity) {
        id = entity.getId();
        name = entity.getname();
        cpf = entity.getCpf();
        income = entity.getincome();
        birthDate = entity.getbirthDate();
        children = entity.getchildren();
    }

    public Long getId() {
        return id;
    }

    public String getname() {
        return name;
    }

    public String getCpf() {
        return cpf;
    }

    public Double getincome() {
        return income;
    }

    public LocalDate getbirthDate() {
        return birthDate;
    }

    public Integer getchildren() {
        return children;
    }
}
