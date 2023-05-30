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

import com.victor.lojavirtual.domain.Permissao;
import com.victor.lojavirtual.service.PermissaoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/permissao")
public class PermissaoController {
	
	@Autowired
	PermissaoService service;

	@GetMapping
	public ResponseEntity<List<Permissao>> listar(){
		List<Permissao> list = service.listar();
		return ResponseEntity.ok().body(list);
	}
	
	@PostMapping
	public ResponseEntity<Permissao> inserir(@Valid @RequestBody Permissao obj){
		Permissao newObj = service.inserir(obj);
		return ResponseEntity.created(null).body(newObj);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Permissao> atualizar(@PathVariable Integer id, @RequestBody Permissao obj){
		Permissao objAtualizado = service.atualizar(id, obj);
		return ResponseEntity.ok().body(objAtualizado);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletar(@PathVariable Integer id) {
		service.deletar(id);
		return ResponseEntity.noContent().build();
	}

}
