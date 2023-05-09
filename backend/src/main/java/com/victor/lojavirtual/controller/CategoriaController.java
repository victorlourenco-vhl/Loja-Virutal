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

import com.victor.lojavirtual.domain.Categoria;
import com.victor.lojavirtual.service.CategoriaService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/categoria")
public class CategoriaController {

	@Autowired
	CategoriaService service;

	@GetMapping
	public ResponseEntity<List<Categoria>> listar() {
		List<Categoria> obj = service.listar();
		return ResponseEntity.ok().body(obj);
	}

	@PostMapping
	public ResponseEntity<Categoria> inserir(@Valid @RequestBody Categoria obj) {
		Categoria novoCategoria = service.inserir(obj);
		return ResponseEntity.created(null).body(novoCategoria);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Categoria> atualizar(@PathVariable Integer id, @RequestBody Categoria obj) {
		Categoria objAtualizado = service.atualizar(id, obj);
		return ResponseEntity.ok().body(objAtualizado);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletar(@PathVariable Integer id) {
		service.deletar(id);
		return ResponseEntity.noContent().build();
	}

}
