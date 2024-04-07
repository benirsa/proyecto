package com.polideportivo.springboot.backend.apirest.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.polideportivo.springboot.backend.apirest.models.dao.IReservaDao;
import com.polideportivo.springboot.backend.apirest.models.entity.Reserva;

@Service
public class ReservaServiceImpl implements IReservaService{
	
	@Autowired
	private IReservaDao reservaDao;

	@Override
	@Transactional(readOnly=true)
	public List<Reserva> findAll() {
		// TODO Auto-generated method stub
		return (List<Reserva>) reservaDao.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public Reserva findById(Long id) {
		// TODO Auto-generated method stub
		return reservaDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Reserva save(Reserva reserva) {
		// TODO Auto-generated method stub
		return reservaDao.save(reserva);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		// TODO Auto-generated method stub
		reservaDao.deleteById(id);
	}
}
