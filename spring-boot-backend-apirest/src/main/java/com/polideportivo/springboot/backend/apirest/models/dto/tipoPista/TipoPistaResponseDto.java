package com.polideportivo.springboot.backend.apirest.models.dto.tipoPista;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class TipoPistaResponseDto {
	
	private Long id;
	private String descripcion;
	private Double precio;
}
