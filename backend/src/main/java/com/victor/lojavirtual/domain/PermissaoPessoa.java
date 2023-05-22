package com.victor.lojavirtual.domain;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Entity;

@Entity
public class PermissaoPessoa implements Serializable { 
	
	private final static long serialVersionUID = 1L;

	
	private Date dataCriacao;
	private Date dataAtualizacao;
	
}
