package com.polideportivo.springboot.backend.apirest.models.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.polideportivo.springboot.backend.apirest.mapper.TipoPistaMapper;
import com.polideportivo.springboot.backend.apirest.models.dao.ITipoPistaDao;
import com.polideportivo.springboot.backend.apirest.models.dto.tipoPista.TipoPistaRequestDto;
import com.polideportivo.springboot.backend.apirest.models.dto.tipoPista.TipoPistaResponseDto;
import com.polideportivo.springboot.backend.apirest.models.entity.TipoPista;

@Service
public class TipoPistaServiceImpl implements ITipoPistaService{

	@Autowired
	private ITipoPistaDao pistaDao;
	
	@Autowired
	private TipoPistaMapper pistaMapper;

	@Override
	@Transactional(readOnly=true)
	public List<TipoPistaResponseDto> findAll() {
		// TODO Auto-generated method stub
		List<TipoPista> tipoPistaList = pistaDao.findAll();
		if(tipoPistaList.isEmpty()) {
			return new ArrayList<>();
		}
		else {
			List<TipoPistaResponseDto> tipoPistaResponseDtoList = pistaMapper.entityListToResponseDtoList(tipoPistaList);
			return tipoPistaResponseDtoList;
		}
	}

	@Override
	@Transactional(readOnly=true)
	public TipoPistaResponseDto findById(Long id) {
		// TODO Auto-generated method stub
		Optional<TipoPista> optionalPista = pistaDao.findById(id);
		if(optionalPista.isPresent()) {
			TipoPistaResponseDto tipoPistaResponseDto = pistaMapper.entityToResponseDto(optionalPista.get());
			return tipoPistaResponseDto;
		}
		else {
			throw new IllegalArgumentException("No existe un tipo de pista con el id: " + id);
		}
	}

	@Override
	@Transactional
	public TipoPistaResponseDto save(TipoPistaRequestDto TipoPistaRequestDto) {
		// TODO Auto-generated method stub
		TipoPista pista = pistaMapper.requestDtoToEntity(TipoPistaRequestDto);
		pistaDao.save(pista);
		TipoPistaResponseDto tipoPistaResponseDto = pistaMapper.entityToResponseDto(pista);
		return tipoPistaResponseDto;
	}

	@Override
	@Transactional
	public void delete(Long id) {
		// TODO Auto-generated method stub
		TipoPistaResponseDto tipoPistaResponseDto = this.findById(id);
		TipoPista pista = pistaMapper.responseDtoToEntity(tipoPistaResponseDto);
		pistaDao.delete(pista);
	}

	@Override
	@Transactional
	public TipoPistaResponseDto update(TipoPistaRequestDto TipoPistaRequestDto, Long id) {
		// TODO Auto-generated method stub
		TipoPista pista = pistaMapper.requestDtoToEntity(TipoPistaRequestDto);
		pista.setId(id);
		pistaDao.save(pista);
		TipoPistaResponseDto tipoPistaResponseDto = pistaMapper.entityToResponseDto(pista);
		return tipoPistaResponseDto;
	}
}
