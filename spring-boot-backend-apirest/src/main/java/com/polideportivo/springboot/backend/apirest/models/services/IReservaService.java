package com.polideportivo.springboot.backend.apirest.models.services;

import java.util.List;

import com.polideportivo.springboot.backend.apirest.models.entity.Reserva;

public interface IReservaService {

	public List<Reserva> findAll();
	
	public Reserva findById(Long id);
	
	public Reserva save(Reserva reserva);
	
	public void delete(Long id);
}
