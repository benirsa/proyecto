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

import com.polideportivo.springboot.backend.apirest.models.dto.abonado.AbonadoRequestDto;
import com.polideportivo.springboot.backend.apirest.models.dto.abonado.AbonadoResponseDto;
import com.polideportivo.springboot.backend.apirest.models.services.IAbonadoService;

@CrossOrigin(origins= {"http://localhost:4200"})
@RestController
@RequestMapping("/abonados")
@ControllerAdvice
public class AbonadoRestController {

	@Autowired
	private IAbonadoService abonadoService;
	
	@GetMapping("/")
	public List<AbonadoResponseDto> index(){
		return abonadoService.findAll();
	}
	
	@GetMapping("/{id}")
	public AbonadoResponseDto show(@PathVariable Long id) {
		return abonadoService.findById(id);
	}
	
	@PostMapping("/")
	@ResponseStatus(HttpStatus.CREATED)
	public AbonadoResponseDto create(@RequestBody AbonadoRequestDto abonado) {
		return abonadoService.save(abonado);
	}
	
	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public AbonadoResponseDto update(@RequestBody AbonadoRequestDto abonado, @PathVariable Long id) {
		return abonadoService.update(abonado, id);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		abonadoService.delete(id);
	}
}
