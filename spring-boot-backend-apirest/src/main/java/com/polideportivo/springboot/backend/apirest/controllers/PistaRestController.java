package com.polideportivo.springboot.backend.apirest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import com.polideportivo.springboot.backend.apirest.models.dto.pista.PistaRequestDto;
import com.polideportivo.springboot.backend.apirest.models.dto.pista.PistaResponseDto;
import com.polideportivo.springboot.backend.apirest.models.services.IPistaService;
import com.polideportivo.springboot.backend.apirest.models.services.ITipoPistaService;

@Controller
@RequestMapping("/pistas")
@ControllerAdvice
public class PistaRestController {

	@Autowired
	private IPistaService pistaService;
	
	@Autowired
	private ITipoPistaService tipoPistaService;
	
	@GetMapping("/lista")
	public ModelAndView listadoPistasView() {
		ModelAndView mav = new ModelAndView("listado-pistas");
		mav.addObject("pistas", pistaService.findAll());
		return mav;
	}
	
	@GetMapping("/modificar/{id}")
	public ModelAndView modificarPistaView(@PathVariable Long id) {
		ModelAndView mav = new ModelAndView("modificar-pista");
		mav.addObject("pista", pistaService.findById(id));
		mav.addObject("tipoPistas", tipoPistaService.findAll());
		mav.addObject("id", id);
		return mav;
	}
	
	@GetMapping("/crear")
	public ModelAndView crearPistaView() {
		ModelAndView mav = new ModelAndView("crear-pista");
		mav.addObject("pista", new PistaResponseDto());
		mav.addObject("tipoPistas", tipoPistaService.findAll());
		return mav;
	}
	
	@PostMapping("/crear")
	@ResponseStatus(HttpStatus.CREATED)
	public String create(@RequestBody PistaRequestDto pista) {
		pistaService.save(pista);
		return "redirect:/pistas/lista";
	}
	
	@PostMapping("/modificar/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public String update(@RequestBody PistaRequestDto pista, @PathVariable Long id) {		
		pistaService.save(pista);
		return "redirect:/pistas/lista";
	}
	
	@DeleteMapping("/eliminar/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		pistaService.delete(id);
	}
}
