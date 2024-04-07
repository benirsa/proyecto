package com.polideportivo.springboot.backend.apirest.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.polideportivo.springboot.backend.apirest.models.dao.IAbonadoDao;
import com.polideportivo.springboot.backend.apirest.models.entity.Abonado;

@Service
public class AbonadoServiceImpl implements IAbonadoService{

	@Autowired
	private IAbonadoDao abonadoDao;
	
	@Override
	@Transactional(readOnly=true)
	public List<Abonado> findAll() {
		// TODO Auto-generated method stub
		return (List<Abonado>) abonadoDao.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public Abonado findById(Long id) {
		// TODO Auto-generated method stub
		return abonadoDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Abonado save(Abonado abonado) {
		// TODO Auto-generated method stub
		return abonadoDao.save(abonado);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		// TODO Auto-generated method stub
		abonadoDao.deleteById(id);
	}

}
