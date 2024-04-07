package com.polideportivo.springboot.backend.apirest.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.polideportivo.springboot.backend.apirest.models.dao.ITipoHoraDao;
import com.polideportivo.springboot.backend.apirest.models.entity.TipoHora;

@Service
public class TipoHoraServiceImpl implements ITipoHoraService{
	
	@Autowired
	private ITipoHoraDao tipoHoraDao;

	@Override
	@Transactional(readOnly=true)
	public List<TipoHora> findAll() {
		// TODO Auto-generated method stub
		return (List<TipoHora>) tipoHoraDao.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public TipoHora findById(Long id) {
		// TODO Auto-generated method stub
		return tipoHoraDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public TipoHora save(TipoHora tipoHora) {
		// TODO Auto-generated method stub
		return tipoHoraDao.save(tipoHora);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		// TODO Auto-generated method stub
		tipoHoraDao.deleteById(id);
	}
	
	
}
