package com.barrostech.mc.services;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.barrostech.mc.domain.Categoria;
import com.barrostech.mc.repositories.CategoriaRepository;
import com.barrostech.mc.services.exception.ObjectNotFoundException;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository repo;
	
	public Categoria buscar(Integer id) {
		Categoria obj = repo.findOne(id);
		if (obj == null) {
			throw new ObjectNotFoundException("Objeto não encontrado, Id: "+ id
					+ ", tipo "+ Categoria.class.getName());
		}
		return obj;
		
	}

}
