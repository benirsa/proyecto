package com.polideportivo.springboot.backend.apirest.models.services;

import java.util.List;

import com.polideportivo.springboot.backend.apirest.models.dto.trabajador.TrabajadorRequestDto;
import com.polideportivo.springboot.backend.apirest.models.dto.trabajador.TrabajadorResponseDto;

public interface ITrabajadorService {

	public List<TrabajadorResponseDto> findAll();
	
	public TrabajadorResponseDto findById(Long id);
	
	public TrabajadorResponseDto save(TrabajadorRequestDto usuario);
	
	public TrabajadorResponseDto update(TrabajadorRequestDto usuario, Long id);
	
	public void delete(Long id);
}
