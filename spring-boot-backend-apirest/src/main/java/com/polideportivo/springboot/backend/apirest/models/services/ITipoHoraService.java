package com.polideportivo.springboot.backend.apirest.models.services;

import java.util.List;

import com.polideportivo.springboot.backend.apirest.models.entity.TipoHora;

public interface ITipoHoraService {

	public List<TipoHora> findAll();
	
	public TipoHora findById(Long id);
	
	public TipoHora save(TipoHora tipoHora);
	
	public TipoHora update(TipoHora tipoHora);
	
	public void delete(Long id);
}
