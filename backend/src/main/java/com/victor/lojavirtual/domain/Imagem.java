package com.victor.lojavirtual.domain;

import java.io.Serializable;

import com.victor.lojavirtual.util.ImagemUtil;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;

@Entity
@Table(name = "imagem")
public class Imagem implements Serializable {

	private final static long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String name;

	private String type;

	@Lob
	private byte[] imageData;

	public Imagem() {
	}

	public Imagem(Integer id, String name, String type, byte[] imageData) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.imageData = imageData;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public byte[] getimageData() {
		return ImagemUtil.decompressImage(imageData);
	}

	public void setimageData(byte[] imageData) {
		this.imageData = imageData;
	}

}
