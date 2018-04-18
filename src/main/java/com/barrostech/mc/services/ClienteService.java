package com.barrostech.mc.services;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.barrostech.mc.domain.Cliente;
import com.barrostech.mc.repositories.ClienteRepository;
import com.barrostech.mc.services.exception.ObjectNotFoundException;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository repo;
	
	public Cliente buscar(Integer id) {
		Cliente obj = repo.findOne(id);
		if (obj == null) {
			throw new ObjectNotFoundException("Objeto não encontrado, Id: "+ id
					+ ", tipo "+ Cliente.class.getName());
		}
		return obj;
		
	}

}
