package com.polideportivo.springboot.backend.apirest.models.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.polideportivo.springboot.backend.apirest.mapper.ReservaMapper;
import com.polideportivo.springboot.backend.apirest.models.dao.IReservaDao;
import com.polideportivo.springboot.backend.apirest.models.dto.reserva.ReservaRequestDto;
import com.polideportivo.springboot.backend.apirest.models.dto.reserva.ReservaResponseDto;
import com.polideportivo.springboot.backend.apirest.models.entity.Abonado;
import com.polideportivo.springboot.backend.apirest.models.entity.Reserva;

@Service
public class ReservaServiceImpl implements IReservaService{
	
	@Autowired
	private IReservaDao reservaDao;
	
	@Autowired
	private ReservaMapper reservaMapper;

	@Override
	@Transactional(readOnly=true)
	public List<ReservaResponseDto> findAll() {
		// TODO Auto-generated method stub
		List<Reserva> reservaList = reservaDao.findAll();
		if(reservaList.isEmpty()) {
			return new ArrayList<>();
		}
		else {
			List<ReservaResponseDto> reservaResponseDto = reservaMapper.entityListToResponseDtoList(reservaList);
			return reservaResponseDto;
		}
	}

	@Override
	@Transactional(readOnly=true)
	public ReservaResponseDto findById(Long id) {
		// TODO Auto-generated method stub
		Optional<Reserva> optionalReserva = reservaDao.findById(id);
		if(optionalReserva.isPresent()) {
			ReservaResponseDto reservaResponseDto = reservaMapper.entityToResponseDto(optionalReserva.get());
			return reservaResponseDto;
		}
		else {
			throw new IllegalArgumentException("No existe una reserva con el id: " + id);
		}
	}

	@Override
	@Transactional
	public ReservaResponseDto save(ReservaRequestDto reservaRequestDto) {
		// TODO Auto-generated method stub
		Reserva reserva = reservaMapper.requestDtoToEntity(reservaRequestDto);
		reserva.setPrecioReserva(this.calcularPrecioReserva(reserva));
		reservaDao.save(reserva);
		ReservaResponseDto reservaResponseDto = reservaMapper.entityToResponseDto(reserva);
		return reservaResponseDto;
	}

	@Override
	@Transactional
	public void delete(Long id) {
		// TODO Auto-generated method stub
		ReservaResponseDto reservaResponseDto = this.findById(id);
		Reserva reserva = reservaMapper.responseDtoToEntity(reservaResponseDto);
		reservaDao.delete(reserva);
	}

	@Override
	@Transactional
	public ReservaResponseDto update(ReservaRequestDto reservaRequestDto, Long id) {
		// TODO Auto-generated method stub
		Reserva reserva = reservaMapper.requestDtoToEntity(reservaRequestDto);
		reserva.setId(id);
		reserva.setPrecioReserva(this.calcularPrecioReserva(reserva));
		ReservaResponseDto reservaResponseDto = reservaMapper.entityToResponseDto(reserva);
		return reservaResponseDto;
	}

	@Override
	public Double calcularPrecioReserva(Reserva reserva) {
		// TODO Auto-generated method stub
		Double precio = reserva.getPista().getTipoPista().getPrecio();
		
		Abonado abonado = reserva.getAbonado();
		int numReservas = reservaDao.findCountByAbonadoDni(abonado.getDni());
		
		// si ha hecho un multiplo de 5 reservas se aplica un descuento del 15% a la reserva de la pista
		if(numReservas % 5 == 0) {
			// si ha comitido 3 faltas, no se aplica el descuento
			if(abonado.getFaltas() == 3) {
				abonado.setFaltas(0);
			}
			else {
				precio *= 0.15;
			}
		}
		
		// redondeamos el precio a dos decimales
		precio = Math.round(precio * 100.0) / 100.0;
		
		return precio;
	}
}
