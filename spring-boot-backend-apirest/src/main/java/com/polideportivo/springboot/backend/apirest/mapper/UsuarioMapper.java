package com.polideportivo.springboot.backend.apirest.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.polideportivo.springboot.backend.apirest.models.dto.usuario.UsuarioRequestDto;
import com.polideportivo.springboot.backend.apirest.models.dto.usuario.UsuarioResponseDto;
import com.polideportivo.springboot.backend.apirest.models.entity.Usuario;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {

	Usuario responseDtoToEntity(UsuarioResponseDto dto);
	Usuario responseDtoToEntity(Long id, UsuarioResponseDto dto);
	Usuario requestDtoToEntity(UsuarioRequestDto dto);
	UsuarioResponseDto entityToResponseDto(Usuario usuario);
	List<UsuarioResponseDto> entityListToResponseDtoList(List<Usuario> usuario);
}
