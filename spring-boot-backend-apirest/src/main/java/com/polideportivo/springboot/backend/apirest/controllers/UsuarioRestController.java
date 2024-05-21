package com.polideportivo.springboot.backend.apirest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.polideportivo.springboot.backend.apirest.models.entity.Usuario;
import com.polideportivo.springboot.backend.apirest.models.services.IUsuarioService;

@CrossOrigin(origins= {"http://localhost:4200"})
@RestController
@RequestMapping("/usuarios")
@ControllerAdvice
public class UsuarioRestController {

	@Autowired
	private IUsuarioService usuarioService;
	
	@GetMapping("/")
	public List<Usuario> index(){
		return usuarioService.findAll();
	}
	
	@GetMapping("/{id}")
	public Usuario show(@PathVariable Long id) {
		return usuarioService.findById(id);
	}
	
	@PostMapping("/")
	@ResponseStatus(HttpStatus.CREATED)
	public Usuario create(@RequestBody Usuario abonado) {
		return usuarioService.save(abonado);
	}
	
	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Usuario update(@RequestBody Usuario usuario, @PathVariable Long id) {
		Usuario usuarioActual = usuarioService.findById(id);
		
		usuarioActual.setDni(usuario.getDni());
		usuarioActual.setNombre(usuario.getNombre());
		usuarioActual.setApellido1(usuario.getApellido1());
		usuarioActual.setApellido2(usuario.getApellido2());
		usuarioActual.setFechaNacimiento(usuario.getFechaNacimiento());
		usuarioActual.setTelefono(usuario.getTelefono());
		usuarioActual.setUsuario(usuario.getUsuario());
		usuarioActual.setContrasena(usuario.getContrasena());
		usuarioActual.setTipoUsuario(usuario.getTipoUsuario());
		
		return usuarioService.save(usuarioActual);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		usuarioService.delete(id);
	}
}
