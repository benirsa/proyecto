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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.polideportivo.springboot.backend.apirest.models.dto.tipoHora.TipoHoraRequestDto;
import com.polideportivo.springboot.backend.apirest.models.dto.tipoHora.TipoHoraResponseDto;
import com.polideportivo.springboot.backend.apirest.models.services.ITipoHoraService;

@CrossOrigin(origins= {"http://localhost:4200"})
@RestController
@RequestMapping("/tipo-hora")
@ControllerAdvice
public class TipoHoraRestController {

	@Autowired
	private ITipoHoraService service;
	
	@GetMapping("/")
	private List<TipoHoraResponseDto> index(){
		return service.findAll();
	}
	
	@GetMapping("/{id}")
	private TipoHoraResponseDto show(@PathVariable Long id) {
		return service.findById(id);
	}
	
	@PostMapping("/")
	private TipoHoraResponseDto create(@RequestBody TipoHoraRequestDto tipoHora) {
		return service.save(tipoHora);
	}
	
	@PutMapping("/{id}")
	private TipoHoraResponseDto update(@PathVariable Long id, @RequestParam TipoHoraRequestDto tipoHora) {
		return service.update(tipoHora, id);
	}
	
	@DeleteMapping("/{id}")
	private void delete(@PathVariable Long id) {
		service.delete(id);
	}
}
