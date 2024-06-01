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
}
