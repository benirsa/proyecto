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

import com.polideportivo.springboot.backend.apirest.models.dto.reserva.ReservaRequestDto;
import com.polideportivo.springboot.backend.apirest.models.dto.reserva.ReservaResponseDto;
import com.polideportivo.springboot.backend.apirest.models.services.IReservaService;

@CrossOrigin(origins= {"http://localhost:4200"})
@RestController
@RequestMapping("/reservas")
@ControllerAdvice
public class ReservaRestController {

	@Autowired
	private IReservaService reservaService;
	
	@GetMapping("/lista")
	public ModelAndView listadoReservasView() {
		ModelAndView mav = new ModelAndView("listado-reservas");
		mav.addObject("reservas", reservaService.findAll());
		return mav;
	}
	
	@GetMapping("/modificar/{id}")
	public ModelAndView modificarReservaView(@PathVariable Long id) {
		ModelAndView mav = new ModelAndView("crear-modificar-reserva");
		mav.addObject("reserva", reservaService.findById(id));
		mav.addObject("modificar", true);
		return mav;
	}
	
	@GetMapping("/crear")
	public ModelAndView crearReservaView() {
		ModelAndView mav = new ModelAndView("crear-modificar-reserva");
		mav.addObject("reserva", null);
		mav.addObject("modificar", false);
		return mav;
	}
	
	@PostMapping("/")
	@ResponseStatus(HttpStatus.CREATED)
	public ReservaResponseDto create(@RequestBody ReservaRequestDto abonado) {
		return reservaService.save(abonado);
	}
	
	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public ReservaResponseDto update(@RequestBody ReservaRequestDto reserva, @PathVariable Long id) {
		return reservaService.save(reserva);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		reservaService.delete(id);
	}
}
