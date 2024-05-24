package com.polideportivo.springboot.backend.apirest.models.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.polideportivo.springboot.backend.apirest.mapper.TipoHoraMapper;
import com.polideportivo.springboot.backend.apirest.models.dao.ITipoHoraDao;
import com.polideportivo.springboot.backend.apirest.models.dto.tipoHora.TipoHoraRequestDto;
import com.polideportivo.springboot.backend.apirest.models.dto.tipoHora.TipoHoraResponseDto;
import com.polideportivo.springboot.backend.apirest.models.entity.TipoHora;

@Service
public class TipoHoraServiceImpl implements ITipoHoraService{
	
	@Autowired
	private ITipoHoraDao horaDao;
	
	@Autowired
	private TipoHoraMapper horaMapper;

	@Override
	@Transactional(readOnly=true)
	public List<TipoHoraResponseDto> findAll() {
		// TODO Auto-generated method stub
		List<TipoHora> tipoHoraList = horaDao.findAll();
		if(tipoHoraList.isEmpty()) {
			return new ArrayList<>();
		}
		else {
			List<TipoHoraResponseDto> tipoHoraResponseDtoList = horaMapper.entityListToResponseDtoList(tipoHoraList);
			return tipoHoraResponseDtoList;
		}
	}

	@Override
	@Transactional(readOnly=true)
	public TipoHoraResponseDto findById(Long id) {
		// TODO Auto-generated method stub
		Optional<TipoHora> optionalHora = horaDao.findById(id);
		if(optionalHora.isPresent()) {
			TipoHoraResponseDto tipoHoraResponseDto = horaMapper.entityToResponseDto(optionalHora.get());
			return tipoHoraResponseDto;
		}
		else {
			throw new IllegalArgumentException("No existe una hora con el id: " + id);
		}
	}

	@Override
	@Transactional
	public TipoHoraResponseDto save(TipoHoraRequestDto tipoHora) {
		// TODO Auto-generated method stub
		TipoHora hora = horaMapper.requestDtoToEntity(tipoHora);
		horaDao.save(hora);
		TipoHoraResponseDto tipoHoraResponseDto = horaMapper.entityToResponseDto(hora);
		return tipoHoraResponseDto; 
	}

	@Override
	@Transactional
	public void delete(Long id) {
		// TODO Auto-generated method stub
		TipoHoraResponseDto tipoHoraResponseDto = this.findById(id);
		TipoHora hora = horaMapper.responseDtoToEntity(tipoHoraResponseDto);
		horaDao.delete(hora);
	}

	@Override
	@Transactional
	public TipoHoraResponseDto update(TipoHoraRequestDto tipoHora, Long id) {
		// TODO Auto-generated method stub
		TipoHora hora = horaMapper.requestDtoToEntity(tipoHora);
		hora.setId(id);
		horaDao.save(hora);
		TipoHoraResponseDto tipoHoraResponseDto = horaMapper.entityToResponseDto(hora);
		return tipoHoraResponseDto;
	}
	
	
}
