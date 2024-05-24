package com.polideportivo.springboot.backend.apirest.models.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.polideportivo.springboot.backend.apirest.mapper.UsuarioMapper;
import com.polideportivo.springboot.backend.apirest.models.dao.IUsuarioDao;
import com.polideportivo.springboot.backend.apirest.models.dto.usuario.UsuarioRequestDto;
import com.polideportivo.springboot.backend.apirest.models.dto.usuario.UsuarioResponseDto;
import com.polideportivo.springboot.backend.apirest.models.entity.Usuario;

@Service
public class UsuarioServiceImpl implements IUsuarioService{

	@Autowired
	private IUsuarioDao usuarioDao;
	
	@Autowired
	private UsuarioMapper usuarioMapper;

	@Override
	@Transactional(readOnly=true)
	public List<UsuarioResponseDto> findAll() {
		// TODO Auto-generated method stub
		List<Usuario> usuarioList = usuarioDao.findAll();
		if(usuarioList.isEmpty()) {
			return new ArrayList<>();
		}
		else {
			List<UsuarioResponseDto> usuarioResponseDtoList = usuarioMapper.entityListToResponseDtoList(usuarioList);
			return usuarioResponseDtoList;
		}
	}

	@Override
	@Transactional(readOnly=true)
	public UsuarioResponseDto findById(Long id) {
		// TODO Auto-generated method stub
		Optional<Usuario> optionalUsuario = usuarioDao.findById(id);
		if(optionalUsuario.isPresent()) {
			UsuarioResponseDto usuarioResponseDto = usuarioMapper.entityToResponseDto(optionalUsuario.get()); 
			return usuarioResponseDto;
		}
		else {
			throw new IllegalArgumentException("No existe un usuario con el id: " + id);
		}
	}

	@Override
	@Transactional
	public UsuarioResponseDto save(UsuarioRequestDto usuarioRequestDto) {
		// TODO Auto-generated method stub
		Usuario usuario = usuarioMapper.requestDtoToEntity(usuarioRequestDto);
		usuarioDao.save(usuario);
		UsuarioResponseDto usuarioResponseDto = usuarioMapper.entityToResponseDto(usuario);
		return usuarioResponseDto;
	}

	@Override
	@Transactional
	public void delete(Long id) {
		// TODO Auto-generated method stub
		UsuarioResponseDto usuarioResponseDto = this.findById(id);
		Usuario usuario = usuarioMapper.responseDtoToEntity(usuarioResponseDto);
		usuarioDao.delete(usuario);
	}

	@Override
	@Transactional
	public UsuarioResponseDto update(UsuarioRequestDto usuarioRequestDto, Long id) {
		// TODO Auto-generated method stub
		Usuario usuario = usuarioMapper.requestDtoToEntity(usuarioRequestDto);
		usuario.setId(id);
		usuarioDao.save(usuario);
		UsuarioResponseDto usuarioResponseDto = usuarioMapper.entityToResponseDto(usuario);
		return usuarioResponseDto;
	}
	
	
}
