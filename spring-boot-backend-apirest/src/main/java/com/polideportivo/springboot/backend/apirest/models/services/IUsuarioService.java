package com.polideportivo.springboot.backend.apirest.models.services;

import org.springframework.web.servlet.ModelAndView;

import com.polideportivo.springboot.backend.apirest.models.dto.usuario.UsuarioRequestDto;
import com.polideportivo.springboot.backend.apirest.models.dto.usuario.UsuarioResponseDto;
import com.polideportivo.springboot.backend.apirest.models.entity.Usuario;

import jakarta.servlet.http.HttpServletRequest;

public interface IUsuarioService {

	public UsuarioResponseDto findById(String nombreUsuario);
	public UsuarioResponseDto save(UsuarioRequestDto usuarioRequestDto);
	public UsuarioResponseDto update(UsuarioRequestDto usuarioRequestDto, Long id);
	public void delete(String nombreUsuario);
	public UsuarioResponseDto findByUsuarioAndContrasena(String usuario, String contrasena);
	public ModelAndView loginUsuario(Usuario usuario, HttpServletRequest request);
	public ModelAndView registroUsuario(Usuario usuario);
}
