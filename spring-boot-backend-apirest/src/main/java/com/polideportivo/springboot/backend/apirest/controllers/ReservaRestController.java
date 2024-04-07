package com.polideportivo.springboot.backend.apirest.controllers;

import java.util.List;

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

import com.polideportivo.springboot.backend.apirest.models.entity.Reserva;
import com.polideportivo.springboot.backend.apirest.models.services.IReservaService;

@CrossOrigin(origins= {"http://localhost:4200"})
@RestController
@RequestMapping("/api")
@ControllerAdvice
public class ReservaRestController {

	@Autowired
	private IReservaService reservaService;
	
	@GetMapping("/reserva")
	public List<Reserva> index(){
		return reservaService.findAll();
	}
	
	@GetMapping("/reserva/{id}")
	public Reserva show(@PathVariable Long id) {
		return reservaService.findById(id);
	}
	
	@PostMapping("/reserva")
	@ResponseStatus(HttpStatus.CREATED)
	public Reserva create(@RequestBody Reserva abonado) {
		return reservaService.save(abonado);
	}
	
	@PutMapping("/reserva/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Reserva update(@RequestBody Reserva reserva, @PathVariable Long id) {
		Reserva reservaActual = reservaService.findById(id);
		
		reservaActual.setIdAbonado(reserva.getIdAbonado());
		reservaActual.setFechaReserva(reserva.getFechaReserva());
		reservaActual.setPrecioReserva(reserva.getPrecioReserva());
		reservaActual.setTipoHora(reserva.getTipoHora());
		reservaActual.setTipoPista(reserva.getTipoPista());
		
		return reservaService.save(reservaActual);
	}
	
	@DeleteMapping("/reserva/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		reservaService.delete(id);
	}
}
