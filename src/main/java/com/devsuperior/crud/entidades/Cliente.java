package com.devsuperior.crud.entidades;

import jakarta.persistence.*;

import java.time.LocalDate;
@Entity
@Table(name = "tb_cliente")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String cpf;
    private Double income;
    private LocalDate birthDate;
    private Integer children;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getname() {
        return name;
    }

    public void setname(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Double getincome() {
        return income;
    }

    public void setincome(Double income) {
        this.income = income;
    }

    public LocalDate getbirthDate() {
        return birthDate;
    }

    public void setbirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public Integer getchildren() {
        return children;
    }

    public void setchildren(Integer children) {
        this.children = children;
    }
}