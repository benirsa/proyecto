package com.polideportivo.springboot.backend.apirest.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.polideportivo.springboot.backend.apirest.models.entity.TipoHora;

public interface ITipoHoraDao extends CrudRepository<TipoHora, Long> {

}
