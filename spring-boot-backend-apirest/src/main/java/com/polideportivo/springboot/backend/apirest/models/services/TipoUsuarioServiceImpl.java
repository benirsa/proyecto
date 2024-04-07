package com.polideportivo.springboot.backend.apirest.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.polideportivo.springboot.backend.apirest.models.dao.ITipoUsuarioDao;
import com.polideportivo.springboot.backend.apirest.models.entity.TipoUsuario;

@Service
public class TipoUsuarioServiceImpl implements ITipoUsuarioService{

	@Autowired
	private ITipoUsuarioDao tipoUsuarioDao;

	@Override
	@Transactional(readOnly=true)
	public List<TipoUsuario> findAll() {
		// TODO Auto-generated method stub
		return (List<TipoUsuario>) tipoUsuarioDao.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public TipoUsuario findById(Long id) {
		// TODO Auto-generated method stub
		return tipoUsuarioDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public TipoUsuario save(TipoUsuario tipoUsuario) {
		// TODO Auto-generated method stub
		return tipoUsuarioDao.save(tipoUsuario);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		// TODO Auto-generated method stub
		tipoUsuarioDao.deleteById(id);
	}
	
	
}
