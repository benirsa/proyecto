package com.polideportivo.springboot.backend.apirest.models.dto.usuario;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UsuarioResponseDto {

	public String usuario;
	public String contrasena;
	public String tipo_usuario;
}
