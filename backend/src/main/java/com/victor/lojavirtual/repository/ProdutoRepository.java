package com.victor.lojavirtual.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.victor.lojavirtual.domain.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {

}
