package com.polideportivo.springboot.backend.apirest.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.polideportivo.springboot.backend.apirest.models.entity.TipoUsuario;

public interface ITipoUsuarioDao extends CrudRepository<TipoUsuario, Long> {

}
