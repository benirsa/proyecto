package com.polideportivo.springboot.backend.apirest.models.dto.pista;

import com.polideportivo.springboot.backend.apirest.models.dto.tipoPista.TipoPistaResponseDto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PistaResponseDto {

	private Long id;
	private TipoPistaResponseDto tipoPista;
	private String estado;
	private Boolean techado;
}
