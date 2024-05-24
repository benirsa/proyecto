package com.polideportivo.springboot.backend.apirest.models.services;

import java.util.List;

import com.polideportivo.springboot.backend.apirest.models.dto.tipoHora.TipoHoraRequestDto;
import com.polideportivo.springboot.backend.apirest.models.dto.tipoHora.TipoHoraResponseDto;

public interface ITipoHoraService {

	public List<TipoHoraResponseDto> findAll();
	
	public TipoHoraResponseDto findById(Long id);
	
	public TipoHoraResponseDto save(TipoHoraRequestDto tipoHora);
	
	public TipoHoraResponseDto update(TipoHoraRequestDto tipoHora, Long id);
	
	public void delete(Long id);
}
