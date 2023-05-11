package com.victor.lojavirtual.repository;

import com.victor.lojavirtual.domain.Imagem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ImagemRepository extends JpaRepository<Imagem, Integer> {

    Optional<Imagem> findByName(String name);

}
