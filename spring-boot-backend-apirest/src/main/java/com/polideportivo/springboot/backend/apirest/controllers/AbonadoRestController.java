package com.polideportivo.springboot.backend.apirest.controllers;

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
import org.springframework.web.servlet.ModelAndView;

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
	
	@GetMapping("/lista")
	public ModelAndView listadoAbonadosView() {
		ModelAndView mav = new ModelAndView("listado-abonados");
		mav.addObject("abonados", abonadoService.findAll());
		return mav;
	}
	
	@GetMapping("/modificar/{id}")
	public ModelAndView modificarAbonadoView(@PathVariable Long id) {
		ModelAndView mav = new ModelAndView("crear-modificar-abonado");
		mav.addObject("abonado", abonadoService.findById(id));
		mav.addObject("modificar", true);
		return mav;
	}
	
	@GetMapping("/crear")
	public ModelAndView crearAbonadoView() {
		ModelAndView mav = new ModelAndView("crear-modificar-abonado");
		mav.addObject("abonado", null);
		mav.addObject("modificar", false);
		return mav;
	}
	
	@PostMapping("/crear")
	@ResponseStatus(HttpStatus.CREATED)
	public AbonadoResponseDto create(@RequestBody AbonadoRequestDto abonado) {
		return abonadoService.save(abonado);
	}
	
	@PutMapping("/modificar/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public AbonadoResponseDto update(@RequestBody AbonadoRequestDto abonado, @PathVariable Long id) {
		return abonadoService.update(abonado, id);
	}
	
	@DeleteMapping("/eliminar/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		abonadoService.delete(id);
	}
}
