package com.victor.lojavirtual.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.victor.lojavirtual.domain.Pessoa;
import com.victor.lojavirtual.repository.PessoaRepository;

@Service
public class PessoaService {
	
	@Autowired
	private PessoaRepository rep;
	
	public Pessoa acharPorId(Integer id) {
		Optional<Pessoa> obj = rep.findById(id);
		return obj.orElseThrow();
	}

	public List<Pessoa> listar() {
		return rep.findAll();
	}

	public Pessoa inserir(Pessoa obj) {
		obj.setDataCriacao(new Date());
		return rep.save(obj);
	}

	public Pessoa atualizar(Integer id, Pessoa newObj) {
		Pessoa obj = acharPorId(id);
		obj.setNome(newObj.getNome());
		obj.setCpf(newObj.getCpf());
		obj.setEmail(newObj.getEmail());
		obj.setEndereco(newObj.getEndereco());
		obj.setCep(newObj.getCep());
		obj.setCidade(newObj.getCidade());
		obj.setDataAtualizacao(new Date());
		return rep.save(obj);
	}

	public void deletar(Integer id) {
		Pessoa obj = acharPorId(id);
		rep.delete(obj);
	}

}
