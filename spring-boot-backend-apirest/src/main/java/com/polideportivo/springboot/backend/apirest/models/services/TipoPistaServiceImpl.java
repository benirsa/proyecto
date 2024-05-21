package com.polideportivo.springboot.backend.apirest.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.polideportivo.springboot.backend.apirest.models.dao.ITipoPistaDao;
import com.polideportivo.springboot.backend.apirest.models.entity.TipoPista;

@Service
public class TipoPistaServiceImpl implements ITipoPistaService{

	@Autowired
	private ITipoPistaDao tipoPistaDao;

	@Override
	@Transactional(readOnly=true)
	public List<TipoPista> findAll() {
		// TODO Auto-generated method stub
		return (List<TipoPista>) tipoPistaDao.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public TipoPista findById(Long id) {
		// TODO Auto-generated method stub
		return tipoPistaDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public TipoPista save(TipoPista tipoPista) {
		// TODO Auto-generated method stub
		return tipoPistaDao.save(tipoPista);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		// TODO Auto-generated method stub
		tipoPistaDao.deleteById(id);
	}

	@Override
	public TipoPista update(TipoPista tipoPista, Long id) {
		// TODO Auto-generated method stub
		TipoPista tipoPistaUpdate = this.findById(id);
		tipoPistaUpdate.setDescripcion(tipoPista.getDescripcion());
		tipoPistaUpdate.setPrecio(tipoPista.getPrecio());
		tipoPistaUpdate.setId(id);
		return tipoPistaDao.save(tipoPistaUpdate);
	}
	
	
}
