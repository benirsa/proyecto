package com.polideportivo.springboot.backend.apirest.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.polideportivo.springboot.backend.apirest.models.dto.tipoHora.TipoHoraRequestDto;
import com.polideportivo.springboot.backend.apirest.models.dto.tipoHora.TipoHoraResponseDto;
import com.polideportivo.springboot.backend.apirest.models.entity.TipoHora;

@Mapper(componentModel = "spring")
public interface TipoHoraMapper {

	TipoHora responseDtoToEntity(TipoHoraResponseDto dto);
	TipoHora responseDtoToEntity(Long id, TipoHoraResponseDto dto);
	TipoHora requestDtoToEntity(TipoHoraRequestDto dto);
	TipoHoraResponseDto entityToResponseDto(TipoHora tipoHora);
	List<TipoHoraResponseDto> entityListToResponseDtoList(List<TipoHora> tipoHora);
}
