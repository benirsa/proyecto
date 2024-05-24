package com.polideportivo.springboot.backend.apirest.models.services;

import java.util.List;

import com.polideportivo.springboot.backend.apirest.models.dto.tipoPista.TipoPistaRequestDto;
import com.polideportivo.springboot.backend.apirest.models.dto.tipoPista.TipoPistaResponseDto;

public interface ITipoPistaService {

	public List<TipoPistaResponseDto> findAll();
	
	public TipoPistaResponseDto findById(Long id);
	
	public TipoPistaResponseDto save(TipoPistaRequestDto tipoPista);
	
	public TipoPistaResponseDto update(TipoPistaRequestDto tipoPista, Long id);
	
	public void delete(Long id);
}
