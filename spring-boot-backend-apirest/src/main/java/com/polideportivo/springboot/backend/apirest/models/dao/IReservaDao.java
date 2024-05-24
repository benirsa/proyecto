package com.polideportivo.springboot.backend.apirest.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.polideportivo.springboot.backend.apirest.models.entity.Reserva;

public interface IReservaDao extends JpaRepository<Reserva, Long> {

	// consulta con query-method para obtener el número de reservas de un abonado por su dni
	public int findCountByAbonadoDni(String dni);
}
