package com.polideportivo.springboot.backend.apirest.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.polideportivo.springboot.backend.apirest.models.dto.abonado.AbonadoRequestDto;
import com.polideportivo.springboot.backend.apirest.models.dto.abonado.AbonadoResponseDto;
import com.polideportivo.springboot.backend.apirest.models.entity.Abonado;

@Mapper(componentModel = "spring")
public interface AbonadoMapper {

	Abonado responseDtoToEntity(AbonadoResponseDto dto);
	Abonado responseDtoToEntity(Long id, AbonadoResponseDto dto);
	Abonado requestDtoToEntity(AbonadoRequestDto dto);
	AbonadoResponseDto entityToResponseDto(Abonado abonado);
	List<AbonadoResponseDto> entityListToResponseDtoList(List<Abonado> abonado);
}
