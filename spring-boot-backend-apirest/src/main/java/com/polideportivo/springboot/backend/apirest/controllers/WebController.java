package com.polideportivo.springboot.backend.apirest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.polideportivo.springboot.backend.apirest.models.entity.Usuario;
import com.polideportivo.springboot.backend.apirest.models.services.IUsuarioService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class WebController {
	
	@Autowired
	private IUsuarioService usuarioService;
	
	public WebController() {
		
	}
	
	@GetMapping("/login")
	public ModelAndView loginView() {
		ModelAndView mav = new ModelAndView("/login");
		mav.addObject("usuario", new Usuario());
		return mav;
	}
	
	@GetMapping("/registro")
	public ModelAndView registroView() {
		ModelAndView mav = new ModelAndView("/login");
		mav.addObject("usuario", new Usuario());
		return mav;
	}
	
	@PostMapping("/login")
	public ModelAndView loginAbonado(@ModelAttribute("usuario") Usuario usuario, HttpServletRequest request) {
		return usuarioService.loginUsuario(usuario, request);
	}
	
	@PostMapping("/registro")
	public ModelAndView registro(@ModelAttribute("usuario") Usuario usuario) {
		return usuarioService.registroUsuario(usuario);
	}
}
