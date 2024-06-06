package com.polideportivo.springboot.backend.apirest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.polideportivo.springboot.backend.apirest.models.dto.tipoHora.TipoHoraRequestDto;
import com.polideportivo.springboot.backend.apirest.models.dto.tipoHora.TipoHoraResponseDto;
import com.polideportivo.springboot.backend.apirest.models.services.ITipoHoraService;

@RestController
@RequestMapping("/tipo-hora")
@ControllerAdvice
public class TipoHoraRestController {

	@Autowired
	private ITipoHoraService horaService;
	
	@GetMapping("/lista")
	public ModelAndView listadoTipoHorasView() {
		ModelAndView mav = new ModelAndView("listado-tipo-horas");
		mav.addObject("horas", horaService.findAll());
		return mav;
	}
	
	@GetMapping("/{id}")
	private TipoHoraResponseDto show(@PathVariable Long id) {
		return horaService.findById(id);
	}
	
	@PostMapping("/crear")
	private TipoHoraResponseDto create(@RequestBody TipoHoraRequestDto tipoHora) {
		return horaService.save(tipoHora);
	}
	
	@PutMapping("/modificar/{id}")
	private TipoHoraResponseDto update(@PathVariable Long id, @RequestParam TipoHoraRequestDto tipoHora) {
		return horaService.update(tipoHora, id);
	}
	
	@DeleteMapping("/eliminar/{id}")
	private void delete(@PathVariable Long id) {
		horaService.delete(id);
	}
}
