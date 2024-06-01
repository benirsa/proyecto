package com.polideportivo.springboot.backend.apirest.controllers;

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
import org.springframework.web.servlet.ModelAndView;

import com.polideportivo.springboot.backend.apirest.models.dto.tipoPista.TipoPistaRequestDto;
import com.polideportivo.springboot.backend.apirest.models.dto.tipoPista.TipoPistaResponseDto;
import com.polideportivo.springboot.backend.apirest.models.services.ITipoPistaService;

@CrossOrigin(origins= {"http://localhost:4200"})
@RestController
@RequestMapping("/tipo-pista")
@ControllerAdvice
public class TipoPistaRestController {

	@Autowired
	private ITipoPistaService tipoPistaService;
	
	@GetMapping("/lista")
	public ModelAndView listadoTipoPistasView() {
		ModelAndView mav = new ModelAndView("listado-tipo-pistas");
		mav.addObject("tipoPistas", tipoPistaService.findAll());
		return mav;
	}
	
	@GetMapping("/modificar/{id}")
	public ModelAndView modificarTipoPistaView(@PathVariable Long id) {
		ModelAndView mav = new ModelAndView("crear-modificar-tipo-pista");
		mav.addObject("tipoPista", tipoPistaService.findById(id));
		mav.addObject("modificar", true);
		return mav;
	}
	
	@GetMapping("/crear")
	public ModelAndView crearTipoPistaView() {
		ModelAndView mav = new ModelAndView("crear-modificar-tipo-pista");
		mav.addObject("tipoPista", null);
		mav.addObject("modificar", false);
		return mav;
	}
	
	@PostMapping("/")
	private TipoPistaResponseDto add(@RequestBody TipoPistaRequestDto tipoPista) {
		return tipoPistaService.save(tipoPista);
	}
	
	@PutMapping("/{id}")
	private TipoPistaResponseDto update(@RequestBody TipoPistaRequestDto tipoPista, @PathVariable Long id) {
		return tipoPistaService.update(tipoPista, id);
	}
	
	@DeleteMapping("/{id}")
	private void delete(@PathVariable Long id) {
		this.tipoPistaService.delete(id);
	}
}
