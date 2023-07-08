package com.devsuperior.crud.controllers;

import com.devsuperior.crud.dto.ClienteDTO;
import com.devsuperior.crud.entidades.Cliente;
import com.devsuperior.crud.repositories.ClienteRepository;
import com.devsuperior.crud.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping(value= "/clientes")
public class ClienteController {
   @Autowired
   private ClienteService service;

    @GetMapping(value= ("/{id}"))
    public ClienteDTO findById (@PathVariable Long id) {
        ClienteDTO dto= service.findById(id);
        return dto;
    }

}
