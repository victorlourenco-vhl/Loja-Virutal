package com.victor.lojavirtual.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.victor.lojavirtual.domain.Estado;
import com.victor.lojavirtual.repository.EstadoRepository;

@Service
public class EstadoService {

	@Autowired
	private EstadoRepository rep;

	public List<Estado> listar() {
		return rep.findAll();
	}

	public Estado inserir(Estado estado) {
		estado.setDataCriacao(new Date());
		return rep.save(estado);
	}

	public Estado atualizar(Integer id, Estado estado) {
		estado.setId(id);
		estado.setDataAtualizacao(new Date());
		return rep.save(estado);
	}

	public void deletar(Integer id) {
		rep.deleteById(id);
	}

}
