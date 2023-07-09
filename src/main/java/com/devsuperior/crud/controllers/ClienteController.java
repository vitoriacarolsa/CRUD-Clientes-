package com.devsuperior.crud.controllers;

import com.devsuperior.crud.dto.ClienteDTO;
import com.devsuperior.crud.entidades.Cliente;
import com.devsuperior.crud.repositories.ClienteRepository;
import com.devsuperior.crud.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value= "/clients")
public class ClienteController {
   @Autowired
   private ClienteService service;

    @GetMapping(value= ("/{id}"))
    public ClienteDTO findById (@PathVariable Long id) {
        ClienteDTO dto= service.findById(id);
        return dto;
    }

    @GetMapping
    public Page<ClienteDTO> findAll (Pageable pageable) {
        return service.findAll(pageable);
    }

    @PostMapping
    public ClienteDTO insert (@RequestBody ClienteDTO dto) {
        dto=service.insert(dto);
        return dto;
    }

}
