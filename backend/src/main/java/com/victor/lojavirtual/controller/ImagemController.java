package com.victor.lojavirtual.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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
	private ImagemService rep;

	@PostMapping
	public ResponseEntity<?> uploadImage(@RequestParam("imagem") MultipartFile file) throws IOException {
		String response = rep.uploadImage(file);

		return ResponseEntity.status(HttpStatus.OK).body(response);
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> acharImadgemPordId(@PathVariable("id") Integer id) {
		byte[] image = rep.acharImagemPorId(id);

		return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.valueOf("imagem/png")).body(image);
	}

}
