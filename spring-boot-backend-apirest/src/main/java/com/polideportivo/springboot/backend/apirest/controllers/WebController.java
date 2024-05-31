package com.polideportivo.springboot.backend.apirest.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {
	
	public WebController() {
		
	}
	
	@GetMapping("/index")
	public String index() {
		return "index";
	}

	@GetMapping("/lista-abonados")
	public String listadoAbonadosView() {
		return "listado-abonados";
	}
	
	@GetMapping("/lista-pistas")
	public String listadoPistas() {
		return "listado-pistas";
	}
	
	@GetMapping("/lista-reservas")
	public String listadoReservas() {
		return "listado-reservas";
	}
	
	@GetMapping("/lista-trabajadores")
	public String listadoTrabajadores() {
		return "listado-trabajadores";
	}
	
	@GetMapping("/lista-tipo-horas")
	public String listadoTipoHoras() {
		return "listado-tipo-horas";
	}
	
	@GetMapping("/lista-tipo-pistas")
	public String listadoTipoPistas() {
		return "listado-tipo-pistas";
	}
	
	@GetMapping("/abonado/update/{id}")
	public String modificarAbonado() {
		return "crear-modificar-abonado";
	}
	
	@GetMapping("/pista/update/{id}")
	public String modificarPista() {
		return "crear-modificar-pista";
	}
	
	@GetMapping("/reserva/update/{id}")
	public String modificarReserva() {
		return "crear-modificar-reserva";
	}
	
	@GetMapping("/tipo-pista/update/{id}")
	public String modificarTipoPista() {
		return "crear-modificar-tipo-pista";
	}
	
	@GetMapping("/trabajador/update/{id}")
	public String modificarTrabajador() {
		return "crear-modificar-trabajador";
	}
	
	@GetMapping("/abonado/create")
	public String crearAbonado() {
		return "crear-modificar-abonado";
	}
	
	@GetMapping("/pista/create")
	public String crearPista() {
		return "crear-modificar-pista";
	}
	
	@GetMapping("/reserva/create")
	public String crearReserva() {
		return "crear-modificar-reserva";
	}
	
	@GetMapping("/tipo-pista/create")
	public String crearTipoPista() {
		return "crear-modificar-tipo-pista";
	}
	
	@GetMapping("/trabajador/create")
	public String crearTrabajador() {
		return "crear-modificar-trabajador";
	}
}
