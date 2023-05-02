package com.victor.lojavirtual.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.victor.lojavirtual.domain.Estado;
import com.victor.lojavirtual.service.EstadoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/estado")
public class EstadoController {
	
	@Autowired
	EstadoService service;

	@GetMapping
	public ResponseEntity<List<Estado>> listar(){
		List<Estado> estados = service.listar();
		return ResponseEntity.ok().body(estados);
	}
	
	@PostMapping
	public ResponseEntity<Estado> inserir(@Valid @RequestBody Estado estado){
		Estado novoEstado = service.inserir(estado);
		return ResponseEntity.created(null).body(novoEstado);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Estado> atualizar(@PathVariable Integer id, @RequestBody Estado estado){
		Estado estadoAtualizado = service.atualizar(id, estado);
		return ResponseEntity.ok().body(estadoAtualizado);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletar(@PathVariable Integer id) {
		service.deletar(id);
		return ResponseEntity.noContent().build();
	}

}
