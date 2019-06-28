package com.ufc.entity;

public class Maquina {
	
	private Integer id;
	private String nome;
	private boolean status;
	
	
	public Maquina(Integer id, String nome, boolean status) {
		this.id = id;
		this.nome = nome;
		this.status = status;
	}
	
	public Maquina () {}

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

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
	
}