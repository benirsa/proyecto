package com.polideportivo.springboot.backend.apirest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.polideportivo.springboot.backend.apirest.models.entity.TipoPista;
import com.polideportivo.springboot.backend.apirest.models.services.ITipoPistaService;

@CrossOrigin(origins= {"http://localhost:4200"})
@RestController
@RequestMapping("/tipo-pista")
@ControllerAdvice
public class TipoPistaRestController {

	@Autowired
	private ITipoPistaService service;
	
	@GetMapping("/")
	private List<TipoPista> index(){
		return service.findAll();
	}
	
	@GetMapping("/{id}")
	private TipoPista show(@PathVariable Long id) {
		return service.findById(id);
	}
	
	@PostMapping("/")
	private TipoPista add(@RequestBody TipoPista tipoPista) {
		return service.save(tipoPista);
	}
	
	@PutMapping("/{id}")
	private TipoPista update(@RequestBody TipoPista tipoPista, @PathVariable Long id) {
		return service.update(tipoPista, id);
	}
	
	@DeleteMapping("/{id}")
	private void delete(@PathVariable Long id) {
		this.service.delete(id);
	}
}
