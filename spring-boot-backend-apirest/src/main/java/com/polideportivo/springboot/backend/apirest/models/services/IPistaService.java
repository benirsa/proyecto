package com.polideportivo.springboot.backend.apirest.models.services;

import java.util.List;

import com.polideportivo.springboot.backend.apirest.models.entity.Pista;

public interface IPistaService {

	public List<Pista> findAll();
	
	public Pista findById(Long id);
	
	public Pista save(Pista pista);
	
	public void delete(Long id);
}
