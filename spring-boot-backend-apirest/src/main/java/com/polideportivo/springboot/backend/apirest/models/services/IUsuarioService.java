package com.polideportivo.springboot.backend.apirest.models.services;

import java.util.List;

import com.polideportivo.springboot.backend.apirest.models.dto.usuario.UsuarioRequestDto;
import com.polideportivo.springboot.backend.apirest.models.dto.usuario.UsuarioResponseDto;

public interface IUsuarioService {

	public List<UsuarioResponseDto> findAll();
	
	public UsuarioResponseDto findById(Long id);
	
	public UsuarioResponseDto save(UsuarioRequestDto usuario);
	
	public UsuarioResponseDto update(UsuarioRequestDto usuario, Long id);
	
	public void delete(Long id);
}
