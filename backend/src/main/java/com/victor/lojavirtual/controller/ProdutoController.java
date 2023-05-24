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

import com.victor.lojavirtual.domain.Produto;
import com.victor.lojavirtual.service.ProdutoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/produto")
public class ProdutoController {
	
	@Autowired
	ProdutoService service;

	@GetMapping
	public ResponseEntity<List<Produto>> listar(){
		List<Produto> objs = service.listar();
		return ResponseEntity.ok().body(objs);
	}
	
	@PostMapping
	public ResponseEntity<Produto> inserir(@Valid @RequestBody Produto obj){
		Produto novoProduto = service.inserir(obj);
		return ResponseEntity.created(null).body(novoProduto);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Produto> atualizar(@PathVariable Integer id, @RequestBody Produto obj){
		Produto objAtualizado = service.atualizar(id, obj);
		return ResponseEntity.ok().body(objAtualizado);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletar(@PathVariable Integer id) {
		service.deletar(id);
		return ResponseEntity.noContent().build();
	}

}
