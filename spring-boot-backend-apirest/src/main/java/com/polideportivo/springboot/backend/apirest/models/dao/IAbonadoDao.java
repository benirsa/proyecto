package com.polideportivo.springboot.backend.apirest.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.polideportivo.springboot.backend.apirest.models.entity.Abonado;

public interface IAbonadoDao extends CrudRepository<Abonado, Long>{

}
