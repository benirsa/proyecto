package com.polideportivo.springboot.backend.apirest.models.dto.reserva;

import java.util.Date;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ReservaRequestDto {

	@NotNull(message = "La pista no puede ser nulo")
	private Long idPista;
	
	@NotNull(message = "La hora no puede ser nulo")
	private Long idTipoHora;
	
	@NotNull(message = "La fecha de la reserva no puede ser nulo")
	private Date fechaReserva;
	
	@NotNull(message = "El abonado no puede ser nulo")
	private Long idAbonado;
	
	@NotNull(message = "El precio de reserva no puede ser nulo")
	private Double precioReserva;
}
