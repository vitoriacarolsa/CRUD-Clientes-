package com.devsuperior.crud.services;

import com.devsuperior.crud.dto.ClienteDTO;
import com.devsuperior.crud.entidades.Cliente;
import com.devsuperior.crud.repositories.ClienteRepository;
import com.devsuperior.crud.services.exceptions.DatabaseException;
import com.devsuperior.crud.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {
   @Autowired
   private ClienteRepository repository;
   @Transactional(readOnly = true)
   public ClienteDTO findById (Long id){
         Cliente cliente = repository.findById(id).orElseThrow
                 (() -> new ResourceNotFoundException("Recurso não encontrado"));
                 return new ClienteDTO(cliente);

    }

    @Transactional(readOnly = true)
    public Page<ClienteDTO> findAll (Pageable pageable){
        Page<Cliente> result= repository.findAll(pageable);
        return result.map(x-> new ClienteDTO(x));
    }

    @Transactional
    public ClienteDTO insert  (ClienteDTO dto){
        Cliente entity= new Cliente();
        copyDtoToEntity (dto, entity);
        entity= repository.save(entity);
        return new ClienteDTO(entity);
    }

    @Transactional
    public ClienteDTO update  (Long id, ClienteDTO dto){
       try{
           Cliente entity= repository.getReferenceById(id);
           copyDtoToEntity (dto, entity);
           entity= repository.save(entity);
           return new ClienteDTO(entity);
       }catch (EntityNotFoundException e){
           throw new ResourceNotFoundException("Recurso não encontrado");
       }

    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Recurso não encontrado");
        }
        try {
            repository.deleteById(id);
        }
        catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Falha de integridade referencial");
        }
    }

    private void copyDtoToEntity(ClienteDTO dto, Cliente entity) {
        entity.setname(dto.getname());
        entity.setCpf(dto.getCpf());
        entity.setincome(dto.getincome());
        entity.setbirthDate(dto.getbirthDate());
        entity.setchildren(dto.getchildren());
    }
}
