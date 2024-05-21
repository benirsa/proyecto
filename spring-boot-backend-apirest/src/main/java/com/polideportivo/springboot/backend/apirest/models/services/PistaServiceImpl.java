package com.polideportivo.springboot.backend.apirest.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.polideportivo.springboot.backend.apirest.models.dao.IPistaDao;
import com.polideportivo.springboot.backend.apirest.models.entity.Pista;

@Service
public class PistaServiceImpl implements IPistaService{
	
	@Autowired
	private IPistaDao pistaDao;

	@Override
	@Transactional(readOnly=true)
	public List<Pista> findAll() {
		// TODO Auto-generated method stub
		return (List<Pista>) pistaDao.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public Pista findById(Long id) {
		// TODO Auto-generated method stub
		return pistaDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Pista save(Pista pista) {
		// TODO Auto-generated method stub
		return pistaDao.save(pista);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		// TODO Auto-generated method stub
		pistaDao.deleteById(id);
	}

	@Override
	public Pista update(Pista pista) {
		// TODO Auto-generated method stub
		return pistaDao.save(pista);
	}
	
	
}
