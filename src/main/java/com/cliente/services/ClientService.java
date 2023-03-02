package com.cliente.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cliente.dto.ClientDTO;
import com.cliente.entities.Client;
import com.cliente.repositories.ClientRepository;
import com.cliente.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ClientService {

	@Autowired
	ClientRepository repository;

	@Transactional(readOnly = true)
	public Page<ClientDTO> findAllPaged(Pageable pageable) {
		
		return repository.findAll(pageable).map(dto -> new ClientDTO(dto));
	}

	@Transactional(readOnly = true)
	public ClientDTO findById(Long id) {
		
		return new ClientDTO(repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Entity not found")));
	}

	@Transactional
	public ClientDTO insert(ClientDTO dto) {
		Client entity = new Client();
		
		toEntity(dto, entity);
		
		return new ClientDTO(repository.save(entity));
	}
	
	@Transactional
	public ClientDTO update(Long id, ClientDTO dto) {
		try {
			Client entity = repository.getReferenceById(id);
			
			toEntity(dto, entity);
			
			return new ClientDTO(repository.save(entity));
	
		}
		catch(EntityNotFoundException e) {
			throw new ResourceNotFoundException("Entity not found");
			
		}
	}
	
	@Transactional(propagation = Propagation.SUPPORTS)
	public void delete(Long id) {
		if (!repository.existsById(id)) {
			throw new ResourceNotFoundException("Entity not found");
		}
		repository.deleteById(id);
	}
	
	public void toEntity(ClientDTO dto, Client entity) {
		entity.setBirthDate(dto.getBirthDate());
		entity.setChildren(dto.getChildren());
		entity.setCpf(dto.getCpf());
		entity.setIncome(dto.getIncome());
		entity.setName(dto.getName());
	}
}
