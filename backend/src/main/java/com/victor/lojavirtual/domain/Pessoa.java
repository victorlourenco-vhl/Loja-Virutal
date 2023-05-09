package com.victor.lojavirtual.domain;

import java.io.Serializable;
import java.util.Date;

import org.hibernate.validator.constraints.br.CPF;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "pessoa")
public class Pessoa implements Serializable {

	private final static long serialVersionUID = 1L;

	@NotBlank(message = "O nome deve ser preenchido")
	private String nome;

	@CPF(message = "CPF inválido")
	private String cpf;

	@Email(message = "E-mail inválido")
	private String email;

	@JsonIgnore
	private String senha;
	private String endereco;
	private String cep;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dataCriacao;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dataAtualizacao;

	@ManyToOne
	@JoinColumn(name = "id_cidade")
	private Cidade cidade;

	public Pessoa() {

	}

	public Pessoa(String nome, String cpf, String email, String senha, String endereco, String cep) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
		this.senha = senha;
		this.endereco = endereco;
		this.cep = cep;
	}

}
