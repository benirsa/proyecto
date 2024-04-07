package com.polideportivo.springboot.backend.apirest.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.polideportivo.springboot.backend.apirest.models.entity.TipoPista;

public interface ITipoPistaDao extends CrudRepository<TipoPista, Long> {

}
