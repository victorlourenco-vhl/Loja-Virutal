package com.victor.lojavirtual.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.victor.lojavirtual.domain.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Integer>{

}
