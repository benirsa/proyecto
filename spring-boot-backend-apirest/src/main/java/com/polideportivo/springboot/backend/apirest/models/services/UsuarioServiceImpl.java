package com.polideportivo.springboot.backend.apirest.models.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.ModelAndView;

import com.polideportivo.springboot.backend.apirest.mapper.UsuarioMapper;
import com.polideportivo.springboot.backend.apirest.models.dao.IRolDao;
import com.polideportivo.springboot.backend.apirest.models.dao.IUsuarioDao;
import com.polideportivo.springboot.backend.apirest.models.dto.usuario.UsuarioRequestDto;
import com.polideportivo.springboot.backend.apirest.models.dto.usuario.UsuarioResponseDto;
import com.polideportivo.springboot.backend.apirest.models.entity.Usuario;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

public class UsuarioServiceImpl implements IUsuarioService {

	@Autowired
	private IUsuarioDao usuarioDao;
	
	@Autowired
	private IRolDao rolDao;
	
	@Autowired
	private BCryptPasswordEncoder encriptador;
	
	@Autowired
	private UsuarioMapper usuarioMapper;
	
	@Override
	public UsuarioResponseDto findById(String nombreUsuario) {
		// TODO Auto-generated method stub
		Optional<Usuario> optionalUsuario = usuarioDao.findById(nombreUsuario);
		if(optionalUsuario.isPresent()) {
			UsuarioResponseDto usuarioResponseDto = usuarioMapper.entityToResponseDto(optionalUsuario.get());
			return usuarioResponseDto;
		}
		else {
			throw new IllegalArgumentException("No existe usuario con el nombre de usuario: " + nombreUsuario);
		}
	}

	@Override
	public UsuarioResponseDto save(UsuarioRequestDto usuarioRequestDto) {
		// TODO Auto-generated method stub
		Usuario usuario = usuarioMapper.requestDtoToEntity(usuarioRequestDto);
		usuarioDao.save(usuario);
		usuario.setContrasena(encriptador.encode(usuario.getContrasena()));
		UsuarioResponseDto usuarioResponseDto = usuarioMapper.entityToResponseDto(usuario);
		return usuarioResponseDto;
	}

	@Override
	public UsuarioResponseDto update(UsuarioRequestDto usuarioRequestDto, Long id) {
		// TODO Auto-generated method stub
		Usuario usuario = usuarioMapper.requestDtoToEntity(usuarioRequestDto);
		usuarioDao.save(usuario);
		UsuarioResponseDto usuarioResponseDto = usuarioMapper.entityToResponseDto(usuario);
		return usuarioResponseDto;
	}

	@Override
	public void delete(String nombreUsuario) {
		// TODO Auto-generated method stub
		UsuarioResponseDto usuarioResponseDto = this.findById(nombreUsuario);
		Usuario usuario = usuarioMapper.responseDtoToEntity(usuarioResponseDto);
		usuarioDao.delete(usuario);
	}

	@Override
	public UsuarioResponseDto findByUsuarioAndContrasena(String nombreUsuario, String contrasena) {
		// TODO Auto-generated method stub
		Usuario usuario = usuarioDao.findUsuarioByUsuarioAndContrasena(nombreUsuario, encriptador.encode(contrasena));
		UsuarioResponseDto usuarioResponseDto = usuarioMapper.entityToResponseDto(usuario);
		return usuarioResponseDto;
	}

	@Override
	public ModelAndView loginUsuario(Usuario usuario, HttpServletRequest request) {
		// TODO Auto-generated method stub
		ModelAndView mav;
		Optional<Usuario> optionalUsuario = usuarioDao.findById(usuario.getUsername());
		if(optionalUsuario.isPresent()) {
			Usuario miUsuario = optionalUsuario.get();
			if(encriptador.matches(usuario.getContrasena(), miUsuario.getContrasena())) {
				HttpSession sesion = request.getSession();
				sesion.setAttribute("usuario", miUsuario);
				mav = new ModelAndView("redirect:/abonados/lista");
			}
			else {
				mav = new ModelAndView("redirect:/login");
				mav.addObject("mensaje", "Usuario o contraseña incorrectos");
			}
		}
		else {
			mav = new ModelAndView("redirect:/login");
			mav.addObject("mensaje", "Usuario no encontrado");
		}
		return mav;
	}

	@Override
	public ModelAndView registroUsuario(Usuario usuario) {
		// TODO Auto-generated method stub
		ModelAndView mav;
		Optional<Usuario> optionalUsuario = usuarioDao.findById(usuario.getUsername());
		if(optionalUsuario.isPresent()) {
			usuario.setRol(rolDao.findById((long) 1).get());
			usuario.setContrasena(encriptador.encode(usuario.getContrasena()));
			usuarioDao.save(usuario);
			mav = new ModelAndView("redirect:/login");
			mav.addObject("mensaje", "Se ha registrado al usuario con éxito");
		}
		else {
			mav = new ModelAndView("redirect:/registro");
			mav.addObject("mensaje", "El usuario ya existe");
		}
		
		return null;
	}

}
