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

import com.polideportivo.springboot.backend.apirest.models.dto.pista.PistaRequestDto;
import com.polideportivo.springboot.backend.apirest.models.dto.pista.PistaResponseDto;
import com.polideportivo.springboot.backend.apirest.models.services.IPistaService;

@CrossOrigin(origins= {"http://localhost:4200"})
@RestController
@RequestMapping("/pistas")
@ControllerAdvice
public class PistaRestController {

	@Autowired
	private IPistaService pistaService;
	
	@GetMapping("/")
	public List<PistaResponseDto> index(){
		return pistaService.findAll();
	}
	
	@GetMapping("/{id}")
	public PistaResponseDto show(@PathVariable Long id) {
		return pistaService.findById(id);
	}
	
	@PostMapping("/")
	@ResponseStatus(HttpStatus.CREATED)
	public PistaResponseDto create(@RequestBody PistaRequestDto abonado) {
		return pistaService.save(abonado);
	}
	
	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public PistaResponseDto update(@RequestBody PistaRequestDto pista, @PathVariable Long id) {		
		return pistaService.save(pista);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		pistaService.delete(id);
	}
}
