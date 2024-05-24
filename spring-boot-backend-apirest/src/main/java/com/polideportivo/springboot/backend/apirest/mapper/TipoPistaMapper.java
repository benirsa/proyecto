package com.polideportivo.springboot.backend.apirest.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.polideportivo.springboot.backend.apirest.models.dto.tipoPista.TipoPistaRequestDto;
import com.polideportivo.springboot.backend.apirest.models.dto.tipoPista.TipoPistaResponseDto;
import com.polideportivo.springboot.backend.apirest.models.entity.TipoPista;

@Mapper(componentModel = "spring")
public interface TipoPistaMapper {

	TipoPista responseDtoToEntity(TipoPistaResponseDto dto);
	TipoPista responseDtoToEntity(Long id, TipoPistaResponseDto dto);
	TipoPista requestDtoToEntity(TipoPistaRequestDto dto);
	TipoPistaResponseDto entityToResponseDto(TipoPista tipoPista);
	List<TipoPistaResponseDto> entityListToResponseDtoList(List<TipoPista> tipoPista);
}
