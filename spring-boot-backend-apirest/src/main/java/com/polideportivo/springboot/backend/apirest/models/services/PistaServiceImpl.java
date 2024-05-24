package com.polideportivo.springboot.backend.apirest.models.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.polideportivo.springboot.backend.apirest.mapper.PistaMapper;
import com.polideportivo.springboot.backend.apirest.models.dao.IPistaDao;
import com.polideportivo.springboot.backend.apirest.models.dto.pista.PistaRequestDto;
import com.polideportivo.springboot.backend.apirest.models.dto.pista.PistaResponseDto;
import com.polideportivo.springboot.backend.apirest.models.entity.Pista;

@Service
public class PistaServiceImpl implements IPistaService{
	
	@Autowired
	private IPistaDao pistaDao;
	
	@Autowired
	private PistaMapper pistaMapper;

	@Override
	@Transactional(readOnly=true)
	public List<PistaResponseDto> findAll() {
		// TODO Auto-generated method stub
		List<Pista> pistaList = pistaDao.findAll();
		if(pistaList.isEmpty()) {
			return new ArrayList<>();
		}
		else {
			List<PistaResponseDto> pistaResponseDto = pistaMapper.entityListToResponseDtoList(pistaList);
			return pistaResponseDto;
		}
	}

	@Override
	@Transactional(readOnly=true)
	public PistaResponseDto findById(Long id) {
		// TODO Auto-generated method stub
		Optional<Pista> optionalPista = pistaDao.findById(id);
		if(optionalPista.isPresent()) {
			PistaResponseDto pistaResponseDto = pistaMapper.entityToResponseDto(optionalPista.get());
			return pistaResponseDto;
		}
		else {
			throw new IllegalArgumentException("No existe pista con el id: " + id);
		}
	}

	@Override
	@Transactional
	public PistaResponseDto save(PistaRequestDto pistaRequestDto) {
		// TODO Auto-generated method stub
		Pista pista = pistaMapper.requestDtoToEntity(pistaRequestDto);
		pistaDao.save(pista);
		PistaResponseDto pistaResponseDto = pistaMapper.entityToResponseDto(pista);
		return pistaResponseDto;
	}

	@Override
	@Transactional
	public void delete(Long id) {
		// TODO Auto-generated method stub
		PistaResponseDto pistaResponsDto = this.findById(id);
		Pista pista = pistaMapper.responseDtoToEntity(pistaResponsDto);
		pistaDao.delete(pista);
	}

	@Override
	@Transactional
	public PistaResponseDto update(PistaRequestDto pistaRequestDto, Long id) {
		// TODO Auto-generated method stub
		Pista pista = pistaMapper.requestDtoToEntity(pistaRequestDto);
		pista.setId(id);
		pistaDao.save(pista);
		PistaResponseDto pistaResponseDto = pistaMapper.entityToResponseDto(pista);
		return pistaResponseDto;
	}
	
	
}
