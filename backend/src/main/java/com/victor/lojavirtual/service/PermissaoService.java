package com.victor.lojavirtual.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.victor.lojavirtual.domain.Permissao;
import com.victor.lojavirtual.repository.PermissaoRepository;

@Service
public class PermissaoService {

	@Autowired
	private PermissaoRepository rep;
	
	public Permissao acharPorId(Integer id) {
		Optional<Permissao> obj = rep.findById(id);
		return obj.orElseThrow();
	}

	public List<Permissao> listar() {
		return rep.findAll();
	}

	public Permissao inserir(Permissao obj) {
		obj.setDataCriacao(new Date());
		return rep.save(obj);
	}

	public Permissao atualizar(Integer id, Permissao newObj) {
		Permissao obj = acharPorId(id);
		return rep.save(obj);
	}

	public void deletar(Integer id) {
		Permissao obj = acharPorId(id);
		rep.delete(obj);
	}

}
