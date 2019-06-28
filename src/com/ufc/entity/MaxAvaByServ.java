package com.ufc.entity;

public class MaxAvaByServ {
	private Integer id;
	private String nome;
	private Integer maxNota;
	
	public MaxAvaByServ(Integer id, String nome, Integer maxNota) {
		super();
		this.id = id;
		this.nome = nome;
		this.maxNota = maxNota;
	}
	
	public MaxAvaByServ() {}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getMaxNota() {
		return maxNota;
	}

	public void setMaxNota(Integer maxNota) {
		this.maxNota = maxNota;
	}
	
}