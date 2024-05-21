package com.polideportivo.springboot.backend.apirest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.polideportivo.springboot.backend.apirest.models.entity.TipoHora;
import com.polideportivo.springboot.backend.apirest.models.services.ITipoHoraService;

@CrossOrigin(origins= {"http://localhost:4200"})
@RestController
@RequestMapping("/tipo-hora")
@ControllerAdvice
public class TipoHoraRestController {

	@Autowired
	private ITipoHoraService service;
	
	@GetMapping("/")
	private List<TipoHora> index(){
		return service.findAll();
	}
	
	@GetMapping("/{id}")
	private TipoHora show(@PathVariable Long id) {
		return service.findById(id);
	}
}
