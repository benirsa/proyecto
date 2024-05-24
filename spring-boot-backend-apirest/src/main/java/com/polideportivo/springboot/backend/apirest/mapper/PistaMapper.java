package com.polideportivo.springboot.backend.apirest.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.polideportivo.springboot.backend.apirest.models.dto.pista.PistaRequestDto;
import com.polideportivo.springboot.backend.apirest.models.dto.pista.PistaResponseDto;
import com.polideportivo.springboot.backend.apirest.models.entity.Pista;

@Mapper(componentModel = "spring")
public interface PistaMapper {

	Pista responseDtoToEntity(PistaResponseDto dto);
	Pista responseDtoToEntity(Long id, PistaResponseDto dto);
	Pista requestDtoToEntity(PistaRequestDto dto);
	PistaResponseDto entityToResponseDto(Pista pista);
	List<PistaResponseDto> entityListToResponseDtoList(List<Pista> pista);
}
