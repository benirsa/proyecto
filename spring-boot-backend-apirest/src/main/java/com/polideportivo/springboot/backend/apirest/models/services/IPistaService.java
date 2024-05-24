package com.polideportivo.springboot.backend.apirest.models.services;

import java.util.List;

import com.polideportivo.springboot.backend.apirest.models.dto.pista.PistaRequestDto;
import com.polideportivo.springboot.backend.apirest.models.dto.pista.PistaResponseDto;

public interface IPistaService {

	public List<PistaResponseDto> findAll();
	
	public PistaResponseDto findById(Long id);
	
	public PistaResponseDto save(PistaRequestDto pista);
	
	public PistaResponseDto update (PistaRequestDto pista, Long id);
	
	public void delete(Long id);
}
