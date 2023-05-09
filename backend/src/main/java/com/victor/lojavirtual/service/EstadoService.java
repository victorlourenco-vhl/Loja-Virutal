package com.victor.lojavirtual.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.victor.lojavirtual.domain.Estado;
import com.victor.lojavirtual.repository.EstadoRepository;

@Service
public class EstadoService {

	@Autowired
	private EstadoRepository rep;
	
	public Estado acharPorId(Integer id) {
		Optional<Estado> obj = rep.findById(id);
		return obj.orElseThrow();
	}

	public List<Estado> listar() {
		return rep.findAll();
	}

	public Estado inserir(Estado estado) {
		estado.setDataCriacao(new Date());
		return rep.save(estado);
	}

	public Estado atualizar(Integer id, Estado newObj) {
		Estado obj = acharPorId(id);
		obj.setNome(newObj.getNome());
		obj.setSigla(newObj.getSigla());
		obj.setDataAtualizacao(new Date());
		return rep.save(obj);
	}

	public void deletar(Integer id) {
		Estado obj = acharPorId(id);
		rep.delete(obj);
	}

}
