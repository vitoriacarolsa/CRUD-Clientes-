package com.devsuperior.crud.repositories;

import com.devsuperior.crud.entidades.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository <Cliente, Long> {
}
