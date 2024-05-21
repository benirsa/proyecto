package com.polideportivo.springboot.backend.apirest.models.services;

import java.util.List;

import com.polideportivo.springboot.backend.apirest.models.entity.TipoPista;

public interface ITipoPistaService {

	public List<TipoPista> findAll();
	
	public TipoPista findById(Long id);
	
	public TipoPista save(TipoPista tipoPista);
	
	public TipoPista update(TipoPista tipoPista, Long id);
	
	public void delete(Long id);
}
