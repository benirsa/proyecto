package com.polideportivo.springboot.backend.apirest.models.dto.reserva;

import java.util.Date;

import com.polideportivo.springboot.backend.apirest.models.dto.abonado.AbonadoRequestDto;
import com.polideportivo.springboot.backend.apirest.models.dto.pista.PistaRequestDto;
import com.polideportivo.springboot.backend.apirest.models.dto.tipoHora.TipoHoraRequestDto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ReservaRequestDto {

	@NotNull(message = "La pista no puede ser nulo")
	private PistaRequestDto pista;
	
	@NotNull(message = "La hora no puede ser nulo")
	private TipoHoraRequestDto tipoHora;
	
	@NotNull(message = "La fecha de la reserva no puede ser nulo")
	private Date fechaReserva;
	
	@NotNull(message = "El abonado no puede ser nulo")
	private AbonadoRequestDto abonado;
	
	@NotNull(message = "El precio de reserva no puede ser nulo")
	private Double precioReserva;
}
