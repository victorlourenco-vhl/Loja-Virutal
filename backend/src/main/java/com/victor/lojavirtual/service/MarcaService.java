package com.victor.lojavirtual.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.victor.lojavirtual.domain.Cidade;
import com.victor.lojavirtual.domain.Marca;
import com.victor.lojavirtual.repository.MarcaRepository;

@Service
public class MarcaService {

	@Autowired
	private MarcaRepository rep;
	
	public Marca acharPorId(Integer id) {
		Optional<Marca> obj = rep.findById(id);
		return obj.orElseThrow();
	}
	
	public Marca inserir(Marca obj) {
		obj.setDataCriacao(new Date());
		return rep.save(obj);
	} 
	
	public List<Marca> listar(){
		return rep.findAll();
	}
	
	public Marca cadastrar(Marca obj) {
		obj.setId(null);
		obj.setDataCriacao(new Date());
		return rep.save(obj);
	}
	
	public Marca atualizar(Integer id, Marca newObj) {
		Marca obj = acharPorId(id);
		obj.setNome(newObj.getNome());
		obj.setDataAtualizacao(new Date());
		return rep.save(obj);
	}
	
	public void deletar(Integer id) {
		Marca obj = acharPorId(id);
		rep.delete(obj);
	}
	
}





