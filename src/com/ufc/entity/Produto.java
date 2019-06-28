package com.ufc.entity;

public class Produto {
	
	private Integer id;
	private String nome;
	private Integer qtd;
	
	public Produto(Integer id, String nome, Integer qtd) {
		this.id = id;
		this.nome = nome;
		this.qtd = qtd;
	}
	
	public Produto () {}

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

	public Integer getQtd() {
		return qtd;
	}

	public void setQtd(Integer qtd) {
		this.qtd = qtd;
	}
	
}