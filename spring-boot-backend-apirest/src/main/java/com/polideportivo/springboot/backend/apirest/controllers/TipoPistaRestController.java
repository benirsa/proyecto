package com.polideportivo.springboot.backend.apirest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.polideportivo.springboot.backend.apirest.models.dto.tipoPista.TipoPistaRequestDto;
import com.polideportivo.springboot.backend.apirest.models.dto.tipoPista.TipoPistaResponseDto;
import com.polideportivo.springboot.backend.apirest.models.services.ITipoPistaService;

@Controller
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
		ModelAndView mav = new ModelAndView("modificar-tipo-pista");
		mav.addObject("tipoPista", tipoPistaService.findById(id));
		mav.addObject("id", id);
		return mav;
	}
	
	@GetMapping("/crear")
	public ModelAndView crearTipoPistaView() {
		ModelAndView mav = new ModelAndView("crear-tipo-pista");
		mav.addObject("tipoPista", new TipoPistaResponseDto());
		return mav;
	}
	
	@PostMapping("/crear")
	private String add(@RequestBody TipoPistaRequestDto tipoPista) {
		tipoPistaService.save(tipoPista);
		return "redirect:/tipo-pista/lista";
	}
	
	@PostMapping("/modificar/{id}")
	private String update(@RequestBody TipoPistaRequestDto tipoPista, @PathVariable Long id) {
		tipoPistaService.update(tipoPista, id);
		return "redirect:/tipo-pista/lista";
	}
	
	@DeleteMapping("/eliminar/{id}")
	private void delete(@PathVariable Long id) {
		this.tipoPistaService.delete(id);
	}
}
