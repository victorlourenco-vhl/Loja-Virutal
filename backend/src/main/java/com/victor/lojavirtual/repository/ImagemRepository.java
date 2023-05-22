package com.victor.lojavirtual.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.victor.lojavirtual.domain.Imagem;

public interface ImagemRepository extends JpaRepository<Imagem, Integer> {

     Optional<Imagem> findByName(String name);

}
