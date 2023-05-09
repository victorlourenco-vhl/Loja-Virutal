package com.victor.lojavirtual.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.victor.lojavirtual.domain.Cidade;
import com.victor.lojavirtual.repository.CidadeRepository;

@Service
public class CidadeService {

	@Autowired
	private CidadeRepository rep;
	
	public Cidade acharPorId(Integer id) {
		Optional<Cidade> obj = rep.findById(id);
		return obj.orElseThrow();
	}

	public List<Cidade> listar() {
		return rep.findAll();
	}

	public Cidade inserir(Cidade obj) {
		obj.setDataCriacao(new Date());
		return rep.save(obj);
	}

	public Cidade atualizar(Integer id, Cidade newObj) {
		Cidade obj = acharPorId(id);
		obj.setNome(newObj.getNome());
		obj.setEstado(newObj.getEstado());
		obj.setDataAtualizacao(new Date());
		return rep.save(obj);
	}

	public void deletar(Integer id) {
		Cidade obj = acharPorId(id);
		rep.delete(obj);
	}

}
