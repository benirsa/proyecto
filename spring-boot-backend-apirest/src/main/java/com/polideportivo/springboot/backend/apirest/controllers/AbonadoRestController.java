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

import com.polideportivo.springboot.backend.apirest.models.dto.abonado.AbonadoRequestDto;
import com.polideportivo.springboot.backend.apirest.models.dto.abonado.AbonadoResponseDto;
import com.polideportivo.springboot.backend.apirest.models.services.IAbonadoService;

@Controller
@RequestMapping("/abonados")
@ControllerAdvice
public class AbonadoRestController {

	@Autowired
	private IAbonadoService abonadoService;
	
	@GetMapping("/lista")
	public ModelAndView listadoAbonadosView() {
		ModelAndView mav = new ModelAndView("listado-abonados");
		mav.addObject("abonados", abonadoService.findAll());
		return mav;
	}
	
	@GetMapping("/modificar/{id}")
	public ModelAndView modificarAbonadoView(@PathVariable Long id) {
		ModelAndView mav = new ModelAndView("modificar-abonado");
		mav.addObject("abonado", abonadoService.findById(id));
		mav.addObject("id", id);
		return mav;
	}
	
	@GetMapping("/crear")
	public ModelAndView crearAbonadoView() {
		ModelAndView mav = new ModelAndView("crear-abonado");
		mav.addObject("abonado", new AbonadoResponseDto());
		return mav;
	}
	
	@PostMapping("/crear")
	@ResponseStatus(HttpStatus.CREATED)
	public String create(@RequestBody AbonadoRequestDto abonado) {
		abonadoService.save(abonado);
		return "redirect:/abonados/lista";
	}
	
	@PostMapping("/modificar/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public String update(@RequestBody AbonadoRequestDto abonado, @PathVariable Long id) {
		abonadoService.update(abonado, id);
		return "redirect:/abonados/lista";
	}
	
	@DeleteMapping("/eliminar/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		abonadoService.delete(id);
	}
}
