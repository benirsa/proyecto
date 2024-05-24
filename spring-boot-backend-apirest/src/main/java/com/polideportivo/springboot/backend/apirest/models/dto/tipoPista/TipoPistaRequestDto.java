package com.polideportivo.springboot.backend.apirest.models.dto.tipoPista;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class TipoPistaRequestDto {

	@NotNull(message = "La descripción no puede ser nulo")
	@Size(max = 50, message = "La descripción ha de tener un máximo de 50 caracteres")
	private String descripcion;
	
	@NotNull(message = "El precio no puede ser nulo")
	private Double precio;
}
