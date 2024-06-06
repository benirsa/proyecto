package com.polideportivo.springboot.backend.apirest.models.dto.tipoPista;

import lombok.Data;

@Data
public class TipoPistaResponseDto {
	
	private Long id;
	private String descripcion;
	private Double precio;
}
