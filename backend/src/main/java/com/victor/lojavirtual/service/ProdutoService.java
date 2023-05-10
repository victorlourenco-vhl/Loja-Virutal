package com.victor.lojavirtual.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.victor.lojavirtual.domain.Produto;
import com.victor.lojavirtual.repository.ProdutoRepository;

@Service
public class ProdutoService {
	
	@Autowired
	private ProdutoRepository rep;
	
	public Produto acharPorId(Integer id) {
		Optional<Produto> obj = rep.findById(id);
		return obj.orElseThrow();
	}

	public List<Produto> listar() {
		return rep.findAll();
	}

	public Produto inserir(Produto obj) {
		obj.setDataCriacao(new Date());
		return rep.save(obj);
	}

	public Produto atualizar(Integer id, Produto newObj) {
		Produto obj = acharPorId(id);
		obj.setDescricaoCurta(newObj.getDescricaoCurta());
		obj.setDescricaoDetalhada(newObj.getDescricaoDetalhada());
		obj.setValorCusto(newObj.getValorCusto());
		obj.setValorVenda(newObj.getValorVenda());
		obj.setDataAtualizacao(new Date());
		obj.setMarca(newObj.getMarca());
		obj.setCategoria(newObj.getCategoria());
		obj.setImagens(newObj.getImagens());
		return rep.save(obj);
	}

	public void deletar(Integer id) {
		Produto obj = acharPorId(id);
		rep.delete(obj);
	}

}
