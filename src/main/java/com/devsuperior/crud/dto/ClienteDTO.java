package com.devsuperior.crud.dto;

import com.devsuperior.crud.entidades.Cliente;

import java.time.LocalDate;

public class ClienteDTO {
    private Long id;
    private String name;
    private String cpf;
    private Double renda;
    private LocalDate datanasc;
    private Integer filhos;

    public ClienteDTO(){
    }

    public ClienteDTO(Long id, String name, String cpf, Double renda, LocalDate datanasc, Integer filhos) {
        this.id = id;
        this.name = name;
        this.cpf = cpf;
        this.renda = renda;
        this.datanasc = datanasc;
        this.filhos = filhos;
    }

    public ClienteDTO(Cliente entity) {
        id = entity.getId();
        name = entity.getname();
        cpf = entity.getCpf();
        renda = entity.getRenda();
        datanasc = entity.getDatanasc();
        filhos = entity.getFilhos();
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

    public Double getRenda() {
        return renda;
    }

    public LocalDate getDatanasc() {
        return datanasc;
    }

    public Integer getFilhos() {
        return filhos;
    }
}
