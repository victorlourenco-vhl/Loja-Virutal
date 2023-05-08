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

import com.victor.lojavirtual.domain.Marca;
import com.victor.lojavirtual.service.MarcaService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/marca")
public class MarcaController {
	
	@Autowired
	MarcaService service;

	@GetMapping
	public ResponseEntity<List<Marca>> listar(){
		List<Marca> marcas = service.listar();
		return ResponseEntity.ok().body(marcas);
	}
	
	@PostMapping
	public ResponseEntity<Marca> inserir(@Valid @RequestBody Marca marca){
		Marca novoMarca = service.inserir(marca);
		return ResponseEntity.created(null).body(novoMarca);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Marca> atualizar(@PathVariable Integer id, @RequestBody Marca marca){
		Marca marcaAtualizado = service.atualizar(id, marca);
		return ResponseEntity.ok().body(marcaAtualizado);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletar(@PathVariable Integer id) {
		service.deletar(id);
		return ResponseEntity.noContent().build();
	}

}
