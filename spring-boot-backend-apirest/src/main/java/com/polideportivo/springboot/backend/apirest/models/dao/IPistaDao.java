package com.polideportivo.springboot.backend.apirest.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.polideportivo.springboot.backend.apirest.models.entity.Pista;

public interface IPistaDao extends CrudRepository<Pista, Long> {

}
