package com.devsuperior.crud.controllers;

import com.devsuperior.crud.dto.ClienteDTO;
import com.devsuperior.crud.entidades.Cliente;
import com.devsuperior.crud.repositories.ClienteRepository;
import com.devsuperior.crud.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value= "/clients")
public class ClienteController {
   @Autowired
   private ClienteService service;

    @GetMapping(value= ("/{id}"))
    public ResponseEntity <ClienteDTO> findById (@PathVariable Long id) {
        ClienteDTO dto= service.findById(id);
        return ResponseEntity.ok(dto);
    }

    @GetMapping
    public  ResponseEntity <Page<ClienteDTO>> findAll (Pageable pageable) {
      Page <ClienteDTO> dto= service.findAll(pageable);
      return ResponseEntity.ok(dto);
    }

    @PostMapping
    public ResponseEntity <ClienteDTO> insert (@RequestBody ClienteDTO dto) {
       dto= service.insert(dto);
       URI uri= ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
               .buildAndExpand(dto.getId()).toUri();
       return ResponseEntity.created(uri).body(dto);
    }

}
