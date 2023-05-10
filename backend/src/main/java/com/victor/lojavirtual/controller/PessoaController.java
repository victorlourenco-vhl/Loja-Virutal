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

import com.victor.lojavirtual.domain.Pessoa;
import com.victor.lojavirtual.service.PessoaService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/pessoa")
public class PessoaController {
	
	@Autowired
	PessoaService service;

	@GetMapping
	public ResponseEntity<List<Pessoa>> listar(){
		List<Pessoa> objs = service.listar();
		return ResponseEntity.ok().body(objs);
	}
	
	@PostMapping
	public ResponseEntity<Pessoa> inserir(@Valid @RequestBody Pessoa obj){
		Pessoa novoPessoa = service.inserir(obj);
		return ResponseEntity.created(null).body(novoPessoa);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Pessoa> atualizar(@PathVariable Integer id, @RequestBody Pessoa obj){
		Pessoa objAtualizado = service.atualizar(id, obj);
		return ResponseEntity.ok().body(objAtualizado);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletar(@PathVariable Integer id) {
		service.deletar(id);
		return ResponseEntity.noContent().build();
	}

}
