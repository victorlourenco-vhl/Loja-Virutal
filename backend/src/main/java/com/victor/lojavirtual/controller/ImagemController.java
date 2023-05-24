package com.victor.lojavirtual.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.victor.lojavirtual.service.ImagemService;

@RestController
@RequestMapping(value = "/imagem")
public class ImagemController {

	@Autowired
	private ImagemService service;

	@PostMapping("/upload/{produtoId}")
	public ResponseEntity<?> uploadFile(@PathVariable Integer produtoId,
			@RequestParam(name = "imagem", required = false) MultipartFile file) throws IOException {
		
		service.inserir(produtoId, file);

		return ResponseEntity.ok().body("Upload realizado com sucesso!");
	}

}
