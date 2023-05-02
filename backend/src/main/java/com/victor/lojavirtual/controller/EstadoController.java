package com.victor.lojavirtual.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/estado")
public class EstadoController {

	@GetMapping
	public String teste() {
		return "estado";
	}

}
