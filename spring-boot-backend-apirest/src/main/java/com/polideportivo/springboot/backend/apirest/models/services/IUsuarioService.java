package com.polideportivo.springboot.backend.apirest.models.services;

import java.util.List;

import com.polideportivo.springboot.backend.apirest.models.entity.Usuario;

public interface IUsuarioService {

	public List<Usuario> findAll();
	
	public Usuario findById(Long id);
	
	public Usuario save(Usuario usuario);
	
	public Usuario update(Usuario usuario);
	
	public void delete(Long id);
}
