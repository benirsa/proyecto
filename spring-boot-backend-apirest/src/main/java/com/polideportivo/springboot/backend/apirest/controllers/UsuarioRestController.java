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

import com.polideportivo.springboot.backend.apirest.models.dto.trabajador.TrabajadorRequestDto;
import com.polideportivo.springboot.backend.apirest.models.dto.trabajador.TrabajadorResponseDto;
import com.polideportivo.springboot.backend.apirest.models.services.ITrabajadorService;

@Controller
@RequestMapping("/trabajadores")
@ControllerAdvice
public class UsuarioRestController {

	@Autowired
	private ITrabajadorService usuarioService;
	
	@GetMapping("/lista")
	public ModelAndView listadoTrabajadoresView() {
		ModelAndView mav = new ModelAndView("listado-trabajadores");
		mav.addObject("usuarios", usuarioService.findAll());
		return mav;
	}
	
	@GetMapping("/modificar/{id}")
	public ModelAndView modificarTrabajadorView(@PathVariable Long id) {
		ModelAndView mav = new ModelAndView("modificar-trabajador");
		mav.addObject("usuario", usuarioService.findById(id));
		mav.addObject("id", id);
		return mav;
	}
	
	@GetMapping("/crear")
	public ModelAndView crearTrabajadorView() {
		ModelAndView mav = new ModelAndView("crear-trabajador");
		mav.addObject("usuario", new TrabajadorResponseDto());
		return mav;
	}
	
	@PostMapping("/crear")
	@ResponseStatus(HttpStatus.CREATED)
	public String create(@RequestBody TrabajadorRequestDto abonado) {
		usuarioService.save(abonado);
		return "redirect:/usuarios/lista";
	}
	
	@PostMapping("/modificar/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public String update(@RequestBody TrabajadorRequestDto usuario, @PathVariable Long id) {
		 usuarioService.update(usuario, id);
		return "redirect:/usuarios/lista";
	}
	
	@DeleteMapping("/eliminar/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		usuarioService.delete(id);
	}
}
