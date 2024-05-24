package com.polideportivo.springboot.backend.apirest.models.dto.reserva;

import java.util.Date;

import com.polideportivo.springboot.backend.apirest.models.dto.abonado.AbonadoResponseDto;
import com.polideportivo.springboot.backend.apirest.models.dto.pista.PistaResponseDto;
import com.polideportivo.springboot.backend.apirest.models.dto.tipoHora.TipoHoraResponseDto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ReservaResponseDto {

	private Long id;
	private PistaResponseDto pista;
	private TipoHoraResponseDto tipoHora;
	private Date fechaReserva;
	private AbonadoResponseDto abonado;
	private Double precioReserva;
}
