package com.polideportivo.springboot.backend.apirest.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.polideportivo.springboot.backend.apirest.models.entity.Reserva;

public interface IReservaDao extends CrudRepository<Reserva, Long> {

}
