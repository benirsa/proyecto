package com.polideportivo.springboot.backend.apirest.models.dto.trabajador;

import java.util.Date;

import com.polideportivo.springboot.backend.apirest.models.dto.usuario.UsuarioResponseDto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class TrabajadorResponseDto {

	private Long id;
	private String dni;
	private String nombre;
	private String apellido1;
	private String apellido2;
	private Date fechaNacimiento;
	private String telefono;
	private UsuarioResponseDto usuario;
}
