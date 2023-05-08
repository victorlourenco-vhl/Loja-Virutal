package com.victor.lojavirtual.domain;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Entity;

@Entity
public class Categoria implements Serializable {

	private final static long serialVersionUID = 1L;

	private String nome;
	private Date dataCriacao;
	private Date dataAtualizacao;

	public Categoria() {

	}

	public Categoria(String nome) {
		super();
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public Date getDataAtualizacao() {
		return dataAtualizacao;
	}

	public void setDataAtualizacao(Date dataAtualizacao) {
		this.dataAtualizacao = dataAtualizacao;
	}

}
