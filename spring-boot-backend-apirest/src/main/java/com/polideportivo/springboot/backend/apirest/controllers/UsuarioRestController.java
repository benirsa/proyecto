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

import com.polideportivo.springboot.backend.apirest.models.dto.usuario.UsuarioRequestDto;
import com.polideportivo.springboot.backend.apirest.models.dto.usuario.UsuarioResponseDto;
import com.polideportivo.springboot.backend.apirest.models.services.IUsuarioService;

@CrossOrigin(origins= {"http://localhost:4200"})
@RestController
@RequestMapping("/usuarios")
@ControllerAdvice
public class UsuarioRestController {

	@Autowired
	private IUsuarioService usuarioService;
	
	@GetMapping("/lista")
	public ModelAndView listadoTrabajadoresView() {
		ModelAndView mav = new ModelAndView("listado-trabajadores");
		mav.addObject("usuarios", usuarioService.findAll());
		return mav;
	}
	
	@GetMapping("/modificar/{id}")
	public ModelAndView modificarTrabajadorView(@PathVariable Long id) {
		ModelAndView mav = new ModelAndView("crear-modificar-trabajador");
		mav.addObject("usuario", usuarioService.findById(id));
		mav.addObject("modificar", true);
		return mav;
	}
	
	@GetMapping("/crear")
	public ModelAndView crearTrabajadorView() {
		ModelAndView mav = new ModelAndView("crear-modificar-trabajador");
		mav.addObject("usuario", null);
		mav.addObject("modificar", false);
		return mav;
	}
	
	@PostMapping("/")
	@ResponseStatus(HttpStatus.CREATED)
	public UsuarioResponseDto create(@RequestBody UsuarioRequestDto abonado) {
		return usuarioService.save(abonado);
	}
	
	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public UsuarioResponseDto update(@RequestBody UsuarioRequestDto usuario, @PathVariable Long id) {
		return usuarioService.update(usuario, id);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		usuarioService.delete(id);
	}
}
