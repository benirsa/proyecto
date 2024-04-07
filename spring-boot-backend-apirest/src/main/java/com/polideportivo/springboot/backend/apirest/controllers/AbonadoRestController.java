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

import com.polideportivo.springboot.backend.apirest.models.entity.Abonado;
import com.polideportivo.springboot.backend.apirest.models.services.IAbonadoService;

@CrossOrigin(origins= {"http://localhost:4200"})
@RestController
@RequestMapping("/api")
@ControllerAdvice
public class AbonadoRestController {

	@Autowired
	private IAbonadoService abonadoService;
	
	@GetMapping("/abonados")
	public List<Abonado> index(){
		return abonadoService.findAll();
	}
	
	@GetMapping("/abonados/{id}")
	public Abonado show(@PathVariable Long id) {
		return abonadoService.findById(id);
	}
	
	@PostMapping("/abonados")
	@ResponseStatus(HttpStatus.CREATED)
	public Abonado create(@RequestBody Abonado abonado) {
		return abonadoService.save(abonado);
	}
	
	@PutMapping("/abonados/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Abonado update(@RequestBody Abonado abonado, @PathVariable Long id) {
		Abonado abonadoActual = abonadoService.findById(id);
		
		abonadoActual.setDni(abonado.getDni());
		abonadoActual.setNombre(abonado.getNombre());
		abonadoActual.setApellido1(abonado.getApellido1());
		abonadoActual.setApellido2(abonado.getApellido2());
		abonadoActual.setDireccion(abonado.getDireccion());
		abonadoActual.setFechaNacimiento(abonado.getFechaNacimiento());
		abonadoActual.setTelefono(abonado.getTelefono());
		
		return abonadoService.save(abonadoActual);
	}
	
	@DeleteMapping("/abonados/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		abonadoService.delete(id);
	}
}
