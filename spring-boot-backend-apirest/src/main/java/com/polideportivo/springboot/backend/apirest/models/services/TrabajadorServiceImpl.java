package com.polideportivo.springboot.backend.apirest.models.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.polideportivo.springboot.backend.apirest.mapper.TrabajadorMapper;
import com.polideportivo.springboot.backend.apirest.models.dao.ITrabajadorDao;
import com.polideportivo.springboot.backend.apirest.models.dto.trabajador.TrabajadorRequestDto;
import com.polideportivo.springboot.backend.apirest.models.dto.trabajador.TrabajadorResponseDto;
import com.polideportivo.springboot.backend.apirest.models.entity.Trabajador;

@Service
public class TrabajadorServiceImpl implements ITrabajadorService{

	@Autowired
	private ITrabajadorDao usuarioDao;
	
	@Autowired
	private TrabajadorMapper usuarioMapper;

	@Override
	@Transactional(readOnly=true)
	public List<TrabajadorResponseDto> findAll() {
		// TODO Auto-generated method stub
		List<Trabajador> usuarioList = usuarioDao.findAll();
		if(usuarioList.isEmpty()) {
			return new ArrayList<>();
		}
		else {
			List<TrabajadorResponseDto> usuarioResponseDtoList = usuarioMapper.entityListToResponseDtoList(usuarioList);
			return usuarioResponseDtoList;
		}
	}

	@Override
	@Transactional(readOnly=true)
	public TrabajadorResponseDto findById(Long id) {
		// TODO Auto-generated method stub
		Optional<Trabajador> optionalUsuario = usuarioDao.findById(id);
		if(optionalUsuario.isPresent()) {
			TrabajadorResponseDto usuarioResponseDto = usuarioMapper.entityToResponseDto(optionalUsuario.get()); 
			return usuarioResponseDto;
		}
		else {
			throw new IllegalArgumentException("No existe un usuario con el id: " + id);
		}
	}

	@Override
	@Transactional
	public TrabajadorResponseDto save(TrabajadorRequestDto usuarioRequestDto) {
		// TODO Auto-generated method stub
		Trabajador usuario = usuarioMapper.requestDtoToEntity(usuarioRequestDto);
		usuarioDao.save(usuario);
		TrabajadorResponseDto usuarioResponseDto = usuarioMapper.entityToResponseDto(usuario);
		return usuarioResponseDto;
	}

	@Override
	@Transactional
	public void delete(Long id) {
		// TODO Auto-generated method stub
		TrabajadorResponseDto usuarioResponseDto = this.findById(id);
		Trabajador usuario = usuarioMapper.responseDtoToEntity(usuarioResponseDto);
		usuarioDao.delete(usuario);
	}

	@Override
	@Transactional
	public TrabajadorResponseDto update(TrabajadorRequestDto usuarioRequestDto, Long id) {
		// TODO Auto-generated method stub
		Trabajador usuario = usuarioMapper.requestDtoToEntity(usuarioRequestDto);
		usuario.setId(id);
		usuarioDao.save(usuario);
		TrabajadorResponseDto usuarioResponseDto = usuarioMapper.entityToResponseDto(usuario);
		return usuarioResponseDto;
	}
	
	
}
