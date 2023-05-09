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

import com.victor.lojavirtual.domain.Cidade;
import com.victor.lojavirtual.service.CidadeService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/cidade")
public class CidadeController {
	
	@Autowired
	CidadeService service;

	@GetMapping
	public ResponseEntity<List<Cidade>> listar(){
		List<Cidade> objs = service.listar();
		return ResponseEntity.ok().body(objs);
	}
	
	@PostMapping
	public ResponseEntity<Cidade> inserir(@Valid @RequestBody Cidade obj){
		Cidade novoCidade = service.inserir(obj);
		return ResponseEntity.created(null).body(novoCidade);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Cidade> atualizar(@PathVariable Integer id, @RequestBody Cidade obj){
		Cidade objAtualizado = service.atualizar(id, obj);
		return ResponseEntity.ok().body(objAtualizado);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletar(@PathVariable Integer id) {
		service.deletar(id);
		return ResponseEntity.noContent().build();
	}

}
