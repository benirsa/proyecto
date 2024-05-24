package com.polideportivo.springboot.backend.apirest.models.dto.abonado;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class AbonadoResponseDto {

	private Long id;
	private String dni;
	private String nombre;
	private String apellido1;
	private String apellido2;
	private Date fechaNacimiento;
	private Integer telefono;
	private String direccion;
}
