package com.polideportivo.springboot.backend.apirest.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.polideportivo.springboot.backend.apirest.models.dto.trabajador.TrabajadorRequestDto;
import com.polideportivo.springboot.backend.apirest.models.dto.trabajador.TrabajadorResponseDto;
import com.polideportivo.springboot.backend.apirest.models.dto.usuario.UsuarioResponseDto;
import com.polideportivo.springboot.backend.apirest.models.entity.Trabajador;
import com.polideportivo.springboot.backend.apirest.models.entity.Usuario;

@Mapper(componentModel = "spring")
public interface TrabajadorMapper {

	Trabajador responseDtoToEntity(TrabajadorResponseDto dto);
	Trabajador responseDtoToEntity(Long id, TrabajadorResponseDto dto);
	Trabajador requestDtoToEntity(TrabajadorRequestDto dto);
	TrabajadorResponseDto entityToResponseDto(Trabajador usuario);
	List<TrabajadorResponseDto> entityListToResponseDtoList(List<Trabajador> usuario);
	UsuarioResponseDto usuarioEntityToResponseDto(Usuario usuario);
}
