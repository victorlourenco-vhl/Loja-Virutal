package com.victor.lojavirtual.service;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.victor.lojavirtual.domain.Imagem;
import com.victor.lojavirtual.domain.Produto;
import com.victor.lojavirtual.repository.ImagemRepository;

@Service
public class ImagemService {

	@Autowired
	private ImagemRepository rep;
	
	@Autowired
	private ProdutoService produtoService;

	public Imagem acharPorId(Integer id) {
		Optional<Imagem> obj = rep.findById(id);
		return obj.get();
	}

	public Imagem inserir(Integer produtoId, MultipartFile file) throws IOException {
		Produto produto = produtoService.acharPorId(produtoId);
		
		salvarImagem(file);
		
		Imagem img = new Imagem();
		img.setNome(file.getName());
		img.setProduto(produto);
		img.setDataCriacao(new Date());
		return rep.save(img);
	}
	
	public void salvarImagem(MultipartFile file) throws IOException  {
		Path uploadPath = Paths.get("C:/Users/victor/Pictures/uploads");
		
		if (!Files.exists(uploadPath)) {
			Files.createDirectories(uploadPath);
		}

		try (InputStream inputStream = file.getInputStream()) {
			Path filePath = uploadPath.resolve(file.getOriginalFilename());
			Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
			
		} catch (IOException ioe) {
			throw new IOException("Não foi possível salvar a imagem: " + file.getName(), ioe);
		}
	}

	public List<Imagem> listar() {
		return rep.findAll();
	}

	public Imagem cadastrar(Imagem obj) {
		obj.setId(null);
		return rep.save(obj);
	}

	public Imagem atualizar(Integer id, Imagem newObj) {
		Imagem obj = acharPorId(id);

		return rep.save(obj);
	}

	public void deletar(Integer id) {
		Imagem obj = acharPorId(id);
		rep.delete(obj);
	}

}
