package com.devsuperior.crud.services;

import com.devsuperior.crud.dto.ClienteDTO;
import com.devsuperior.crud.entidades.Cliente;
import com.devsuperior.crud.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class ClienteService {
   @Autowired
   private ClienteRepository repository;
   @Transactional(readOnly = true)
   public ClienteDTO findById (Long id){
        Optional<Cliente> result= repository.findById(id);
        Cliente cliente =result.get();
        ClienteDTO dto = new ClienteDTO(cliente);
        return dto;
    }
}
