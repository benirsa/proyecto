package com.polideportivo.springboot.backend.apirest.models.services;

import java.util.List;

import com.polideportivo.springboot.backend.apirest.models.entity.Abonado;

public interface IAbonadoService {

	public List<Abonado> findAll();
	
	public Abonado findById(Long id);
	
	public Abonado save(Abonado abonado);
	
	public Abonado update(Abonado abonado, Long id);
	
	public void delete(Long id);
}
