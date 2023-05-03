package com.victor.lojavirtual.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.victor.lojavirtual.domain.Marca;
import com.victor.lojavirtual.repository.MarcaRepository;

@Service
public class MarcaService {

	@Autowired
	private MarcaRepository repo;
	
	public Marca acharPorId(Integer id) {
		Optional<Marca> obj = repo.findById(id);
		return obj.orElseThrow();
	}
	
	public List<Marca> listar(){
		return repo.findAll();
	}
	
	public Marca cadastrar(Marca obj) {
		obj.setId(null);
		obj.setDataCriacao(new Date());
		return repo.save(obj);
	}
	
	public Marca atualizar(Integer id, Marca newObj) {
		Marca obj = acharPorId(id);
		obj.setNome(newObj.getNome());
		obj.setDataAtualizacao(new Date());
		return repo.save(obj);
	}
	
	public void deletar(Integer id) {
		acharPorId(id);
		repo.deleteById(id);
	}
	
}





