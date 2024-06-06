package com.polideportivo.springboot.backend.apirest.models.dto.usuario;

import lombok.Data;

@Data
public class UsuarioRequestDto {

	public String usuario;
	public String contrasena;
	public String tipo_usuario;
}
