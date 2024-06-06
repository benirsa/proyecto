package com.polideportivo.springboot.backend.apirest.models.services;

import java.util.List;

import com.polideportivo.springboot.backend.apirest.models.dto.reserva.ReservaRequestDto;
import com.polideportivo.springboot.backend.apirest.models.dto.reserva.ReservaResponseDto;
import com.polideportivo.springboot.backend.apirest.models.entity.Reserva;

public interface IReservaService {

	public List<ReservaResponseDto> findAll();
	
	public List<ReservaResponseDto> findAllByAbonadoId(Long id);
	
	public ReservaResponseDto findById(Long id);
	
	public ReservaResponseDto save(ReservaRequestDto reserva);
	
	public ReservaResponseDto update(ReservaRequestDto reserva, Long id);
	
	public void delete(Long id);
	
	public Double calcularPrecioReserva(Reserva reserva);
}
