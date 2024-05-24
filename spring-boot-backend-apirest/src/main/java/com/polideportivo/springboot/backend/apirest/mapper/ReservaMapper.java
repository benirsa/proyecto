package com.polideportivo.springboot.backend.apirest.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.polideportivo.springboot.backend.apirest.models.dto.reserva.ReservaRequestDto;
import com.polideportivo.springboot.backend.apirest.models.dto.reserva.ReservaResponseDto;
import com.polideportivo.springboot.backend.apirest.models.entity.Reserva;

@Mapper(componentModel = "spring")
public interface ReservaMapper {

	Reserva responseDtoToEntity(ReservaResponseDto dto);
	Reserva responseDtoToEntity(Long id, ReservaResponseDto dto);
	Reserva requestDtoToEntity(ReservaRequestDto dto);
	ReservaResponseDto entityToResponseDto(Reserva reserva);
	List<ReservaResponseDto> entityListToResponseDtoList(List<Reserva> reserva);
}
