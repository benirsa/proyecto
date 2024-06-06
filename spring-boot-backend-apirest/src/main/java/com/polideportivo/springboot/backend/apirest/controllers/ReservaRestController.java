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

import com.polideportivo.springboot.backend.apirest.models.dto.reserva.ReservaRequestDto;
import com.polideportivo.springboot.backend.apirest.models.dto.reserva.ReservaResponseDto;
import com.polideportivo.springboot.backend.apirest.models.services.IAbonadoService;
import com.polideportivo.springboot.backend.apirest.models.services.IPistaService;
import com.polideportivo.springboot.backend.apirest.models.services.IReservaService;
import com.polideportivo.springboot.backend.apirest.models.services.ITipoHoraService;

@Controller
@RequestMapping("/reservas")
@ControllerAdvice
public class ReservaRestController {

	@Autowired
	private IReservaService reservaService;
	
	@Autowired
	private IPistaService pistaService;
	
	@Autowired
	private IAbonadoService abonadoService;
	
	@Autowired
	private ITipoHoraService tipoHoraService;
	
	@GetMapping("/lista")
	public ModelAndView listadoReservasView() {
		ModelAndView mav = new ModelAndView("listado-reservas");
		mav.addObject("reservas", reservaService.findAll());
		return mav;
	}
	
	@GetMapping("/modificar/{id}")
	public ModelAndView modificarReservaView(@PathVariable Long id) {
		ModelAndView mav = new ModelAndView("modificar-reserva");
		mav.addObject("reserva", reservaService.findById(id));
		mav.addObject("pistas", pistaService.findByEstado("ACTIVA"));
		mav.addObject("abonados", abonadoService.findAll());
		mav.addObject("horas", tipoHoraService.findAll());
		mav.addObject("id", id);
		return mav;
	}
	
	@GetMapping("/crear")
	public ModelAndView crearReservaView() {
		ModelAndView mav = new ModelAndView("crear-reserva");
		mav.addObject("reserva", new ReservaResponseDto());
		mav.addObject("pistas", pistaService.findByEstado("ACTIVA"));
		mav.addObject("abonados", abonadoService.findAll());
		mav.addObject("horas", tipoHoraService.findAll());
		return mav;
	}
	
	@PostMapping("/crear")
	@ResponseStatus(HttpStatus.CREATED)
	public String create(@RequestBody ReservaRequestDto abonado) {
		reservaService.save(abonado);
		return "redirect:/abonados/lista";
	}
	
	@PostMapping("/modificar/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public String update(@RequestBody ReservaRequestDto reserva, @PathVariable Long id) {
		reservaService.save(reserva);
		return "redirect:/abonados/lista";
	}
	
	@DeleteMapping("/eliminar/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		reservaService.delete(id);
	}
}
