package com.polideportivo.springboot.backend.apirest.models.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.polideportivo.springboot.backend.apirest.mapper.AbonadoMapper;
import com.polideportivo.springboot.backend.apirest.models.dao.IAbonadoDao;
import com.polideportivo.springboot.backend.apirest.models.dto.abonado.AbonadoRequestDto;
import com.polideportivo.springboot.backend.apirest.models.dto.abonado.AbonadoResponseDto;
import com.polideportivo.springboot.backend.apirest.models.entity.Abonado;

@Service
public class AbonadoServiceImpl implements IAbonadoService{

	@Autowired
	private IAbonadoDao abonadoDao;
	
	@Autowired
	private AbonadoMapper abonadoMapper;
	
	@Override
	@Transactional(readOnly=true)
	public List<AbonadoResponseDto> findAll() {
		// TODO Auto-generated method stub
		List<Abonado> abonadosList = abonadoDao.findAll();
		if(abonadosList.isEmpty()) {
			return new ArrayList<>();
		}
		else {
			List<AbonadoResponseDto> abonadoResponseDtoList = abonadoMapper.entityListToResponseDtoList(abonadosList);
			return abonadoResponseDtoList;
		}
	}

	@Override
	@Transactional(readOnly=true)
	public AbonadoResponseDto findById(Long id) {
		// TODO Auto-generated method stub
		 Optional<Abonado> optionalAbonado = abonadoDao.findById(id);
		 if(optionalAbonado.isPresent()) {
			 AbonadoResponseDto abonadoResponseDto = abonadoMapper.entityToResponseDto(optionalAbonado.get());
			 return abonadoResponseDto;
		 }
		 else {
			 throw new IllegalArgumentException("No existe un abonado con el id: " + id);
		 }
	}

	@Override
	@Transactional
	public AbonadoResponseDto save(AbonadoRequestDto abonadoRequestDto) {
		// TODO Auto-generated method stub
		Abonado abonado = abonadoMapper.requestDtoToEntity(abonadoRequestDto);
		abonadoDao.save(abonado);
		AbonadoResponseDto abonadoResponseDto = abonadoMapper.entityToResponseDto(abonado);
		return abonadoResponseDto;
	}

	@Override
	@Transactional
	public void delete(Long id) {
		// TODO Auto-generated method stub
		AbonadoResponseDto abonadoResponseDto = this.findById(id);
		Abonado abonado = abonadoMapper.responseDtoToEntity(abonadoResponseDto);
		abonadoDao.delete(abonado);
	}

	@Override
	@Transactional
	public AbonadoResponseDto update(AbonadoRequestDto abonadoRequestDto, Long id) {
		// TODO Auto-generated method stub
		Abonado abonado = abonadoMapper.requestDtoToEntity(abonadoRequestDto);
		abonado.setId(id);
		abonadoDao.save(abonado);
		AbonadoResponseDto abonadoResponseDto = abonadoMapper.entityToResponseDto(abonado);
		return abonadoResponseDto;
	}

}
