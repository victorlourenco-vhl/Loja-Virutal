package com.victor.lojavirtual.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.victor.lojavirtual.domain.Categoria;
import com.victor.lojavirtual.domain.Cidade;
import com.victor.lojavirtual.repository.CategoriaRepository;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository rep;
	
	public Categoria acharPorId(Integer id) {
		Optional<Categoria> obj = rep.findById(id);
		return obj.orElseThrow();
	}
	
	public Categoria inserir(Categoria obj) {
		obj.setDataCriacao(new Date());
		return rep.save(obj);
	} 
	
	public List<Categoria> listar(){
		return rep.findAll();
	}
	
	public Categoria cadastrar(Categoria obj) {
		obj.setId(null);
		obj.setDataCriacao(new Date());
		return rep.save(obj);
	}
	
	public Categoria atualizar(Integer id, Categoria newObj) {
		Categoria obj = acharPorId(id);
		obj.setNome(newObj.getNome());
		obj.setDataAtualizacao(new Date());
		return rep.save(obj);
	}
	
	public void deletar(Integer id) {
		Categoria obj = acharPorId(id);
		rep.delete(obj);
	}

}
