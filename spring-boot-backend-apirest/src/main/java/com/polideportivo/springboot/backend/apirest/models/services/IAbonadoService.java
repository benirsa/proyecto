package com.polideportivo.springboot.backend.apirest.models.services;

import java.util.List;

import com.polideportivo.springboot.backend.apirest.models.dto.abonado.AbonadoRequestDto;
import com.polideportivo.springboot.backend.apirest.models.dto.abonado.AbonadoResponseDto;

public interface IAbonadoService {

	public List<AbonadoResponseDto> findAll();
	
	public AbonadoResponseDto findById(Long id);
	
	public AbonadoResponseDto save(AbonadoRequestDto abonado);
	
	public AbonadoResponseDto update(AbonadoRequestDto abonado, Long id);
	
	public void delete(Long id);
}
