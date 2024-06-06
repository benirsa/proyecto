package com.polideportivo.springboot.backend.apirest.mapper;

import com.polideportivo.springboot.backend.apirest.models.dto.usuario.UsuarioRequestDto;
import com.polideportivo.springboot.backend.apirest.models.dto.usuario.UsuarioResponseDto;
import com.polideportivo.springboot.backend.apirest.models.entity.Usuario;

public interface UsuarioMapper {

	UsuarioResponseDto entityToResponseDto(Usuario usuario);
	Usuario responseDtoToEntity(UsuarioResponseDto usuarioResponseDto);
	Usuario requestDtoToEntity(UsuarioRequestDto usuarioRequestDto);
}
