package com.devsuperior.crud.services;

import com.devsuperior.crud.dto.ClienteDTO;
import com.devsuperior.crud.entidades.Cliente;
import com.devsuperior.crud.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
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
        Cliente entity= repository.getReferenceById(id);
        copyDtoToEntity (dto, entity);
        entity= repository.save(entity);
        return new ClienteDTO(entity);
    }

    @Transactional
    public void delete(Long id){
      repository.deleteById(id);
    }

    private void copyDtoToEntity(ClienteDTO dto, Cliente entity) {
        entity.setname(dto.getname());
        entity.setCpf(dto.getCpf());
        entity.setRenda(dto.getRenda());
        entity.setDatanasc(dto.getDatanasc());
        entity.setFilhos(dto.getFilhos());
    }
}
